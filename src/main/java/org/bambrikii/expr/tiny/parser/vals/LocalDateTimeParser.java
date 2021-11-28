package org.bambrikii.expr.tiny.parser.vals;

import org.bambrikii.expr.tiny.algo.ConstantValue;
import org.bambrikii.expr.tiny.parser.ExpressionParserContext;
import org.bambrikii.expr.tiny.parser.ValueParser;
import org.bambrikii.expr.tiny.parser.utils.InstantParserUtils;
import org.bambrikii.expr.tiny.parser.utils.NumericParserUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeParser implements ValueParser<LocalDateTime> {
    @Override
    public boolean parse(ExpressionParserContext ctx) {
        int posDate = ctx.getPos();
        if (ctx.isEol(posDate)) {
            return false;
        }
        Number year = NumericParserUtils.nextDigits(ctx, posDate, 4);
        if (year == null) {
            return false;
        }
        posDate += 4;
        if (!InstantParserUtils.nextDelimiter(ctx, posDate++, '-')) {
            return false;
        }
        Number month = NumericParserUtils.nextDigits(ctx, posDate, 2);
        if (month == null) {
            return false;
        }
        posDate += 2;
        if (!InstantParserUtils.nextDelimiter(ctx, posDate++, '-')) {
            return false;
        }
        Number day = NumericParserUtils.nextDigits(ctx, posDate, 2);
        if (day == null) {
            return false;
        }
        posDate += 2;
        int posTime = posDate;
        int yearInt = year.intValue();
        int monthInt = month.intValue();
        int dayInt = day.intValue();
        if (!InstantParserUtils.nextDelimiter(ctx, posTime, 'T')) {
            Instant instant = Instant.from(LocalDate.of(yearInt, monthInt, dayInt));
            ctx.pushVal(new ConstantValue(instant));
            ctx.setPos(posDate);
            return true;
        }
        posTime++;
        Number hour = NumericParserUtils.nextDigits(ctx, posTime, 2);
        if (hour == null) {
            return false;
        }
        posTime += 2;
        if (!InstantParserUtils.nextDelimiter(ctx, posTime++, ':')) {
            return false;
        }
        Number minute = NumericParserUtils.nextDigits(ctx, posTime, 2);
        if (minute == null) {
            return false;
        }
        posTime += 2;
        if (!InstantParserUtils.nextDelimiter(ctx, posTime++, ':')) {
            return false;
        }
        Number second = NumericParserUtils.nextDigits(ctx, posTime, 2);
        if (second == null) {
            return false;
        }
        posTime += 2;
        LocalDateTime val = LocalDateTime.of(yearInt, monthInt, dayInt, hour.intValue(), minute.intValue(), second.intValue());
        ctx.pushVal(new ConstantValue(val));
        ctx.setPos(posTime);
        return true;
    }
}
