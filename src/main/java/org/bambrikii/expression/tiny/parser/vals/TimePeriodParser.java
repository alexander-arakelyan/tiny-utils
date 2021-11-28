package org.bambrikii.expression.tiny.parser.vals;

import org.bambrikii.expression.tiny.algo.ConstantValue;
import org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodElement;
import org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodType;
import org.bambrikii.expression.tiny.parser.ExpressionParserContext;
import org.bambrikii.expression.tiny.parser.ValueParser;
import org.bambrikii.expression.tiny.parser.utils.NumericParserUtils;
import org.bambrikii.expression.tiny.parser.vals.period.PeriodMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodType.DAY;
import static org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodType.HOUR;
import static org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodType.MIN;
import static org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodType.MONTH;
import static org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodType.SEC;
import static org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodType.WEEK;
import static org.bambrikii.expression.tiny.algo.timeperiod.TimePeriodType.YEAR;

public class TimePeriodParser implements ValueParser {
    private static final Map<TimePeriodType, List<PeriodMatcher>> MATCHERS;
    public static final int DOES_NOT_MATCH_POS = -1;

    static {
        MATCHERS = Map.of(
                YEAR, List.of(new PeriodMatcher("y",
                        new PeriodMatcher("r", new PeriodMatcher("s")),
                        new PeriodMatcher("ear", new PeriodMatcher("s"))
                )),
                MONTH, List.of(new PeriodMatcher("m", new PeriodMatcher("on", new PeriodMatcher("th", new PeriodMatcher("s"))))),
                WEEK, List.of(new PeriodMatcher("w",
                        new PeriodMatcher("k", new PeriodMatcher("s")),
                        new PeriodMatcher("eek", new PeriodMatcher("s"))
                )),
                DAY, List.of(new PeriodMatcher("d", new PeriodMatcher("ay", new PeriodMatcher("s")))),
                HOUR, List.of(new PeriodMatcher("h",
                        new PeriodMatcher("r"),
                        new PeriodMatcher("our", new PeriodMatcher("s"))
                )),
                MIN, List.of(new PeriodMatcher("min", new PeriodMatcher("ute", new PeriodMatcher("s")), new PeriodMatcher("s"))),
                SEC, List.of(new PeriodMatcher("s", new PeriodMatcher("ec",
                        new PeriodMatcher("ond", new PeriodMatcher("s")),
                        new PeriodMatcher("s")
                )))
        );
    }


    @Override
    public boolean parse(ExpressionParserContext ctx) {
        int pos0 = ctx.getPos();
        int pos = pos0;
        List<TimePeriodElement> result = null;
        periods:
        while (true) {
            // parse number
            int num = 0;
            int count = 0;
            while (!ctx.isEol(pos)) {
                char ch = ctx.charAt(pos);
                if (!NumericParserUtils.isNumeric(ch)) {
                    break;
                }
                num = num * 10 + (ch - '0');
                pos++;
                count++;
            }
            if (count == 0) {
                break periods;
            }

            // exhaust spaces
            while (!ctx.isEol(pos) && ctx.charAt(pos) == ' ') {
                pos++;
            }

            // parse type
            TimePeriodType type = null;
            type:
            for (Map.Entry<TimePeriodType, List<PeriodMatcher>> entry : MATCHERS.entrySet()) {
                for (PeriodMatcher matcher : entry.getValue()) {
                    int pos2 = matchesType(ctx, matcher, pos);
                    if (pos2 > pos) {
                        pos = pos2;
                        type = entry.getKey();
                        break type;
                    }
                }
            }
            if (type != null) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new TimePeriodElement(num, type));
            }

            // exhaust spaces
            while (!ctx.isEol(pos) && ctx.charAt(pos) == ' ') {
                pos++;
            }
        }

        if (result == null) {
            return false;
        }
        ctx.pushVal(new ConstantValue(result));
        ctx.setPos(pos);
        return true;
    }

    private int matchesType(ExpressionParserContext ctx, PeriodMatcher matcher, final int pos) {
        String repr = matcher.ch;
        int matches = 0;
        int length = repr.length();
        for (int i = 0; i < length; i++) {
            int pos2 = pos + i;
            if (ctx.isEol(pos2)) {
                break;
            }
            if (ctx.charAt(pos2) != repr.charAt(i)) {
                break;
            } else {
                matches++;
            }
        }
        if (matches != length) {
            return DOES_NOT_MATCH_POS;
        }
        int pos2 = pos + length;
        if (matcher.more.isEmpty()) {
            return pos2;
        }
        for (PeriodMatcher moreMatch : matcher.more) {
            int moreMatchPos = matchesType(ctx, moreMatch, pos2);
            if (moreMatchPos != DOES_NOT_MATCH_POS) {
                return moreMatchPos;
            }
        }
        return pos2;
    }
}

