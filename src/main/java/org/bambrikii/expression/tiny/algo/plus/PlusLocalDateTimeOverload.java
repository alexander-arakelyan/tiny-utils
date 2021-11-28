package org.bambrikii.expression.tiny.algo.plus;

import org.bambrikii.expression.tiny.algo.OperatorOverload;
import org.bambrikii.expression.tiny.algo.PeriodElement;

import java.time.LocalDateTime;
import java.util.List;

public class PlusLocalDateTimeOverload implements OperatorOverload {
    @Override
    public boolean canAccept(Object... args) {
        return args[0] instanceof LocalDateTime;
    }

    @Override
    public Object eval(Object... args) {
        LocalDateTime date = (LocalDateTime) args[0];
        for (PeriodElement period : (List<PeriodElement>) args[1]) {
            date = evalDate(date, period);
        }
        return date;
    }

    private LocalDateTime evalDate(LocalDateTime date, PeriodElement period) {
        int num = period.getNum();
        switch (period.getType()) {
            case YEAR:
                return date.plusYears(num);
            case MONTH:
                return date.plusMonths(num);
            case WEEK:
                return date.plusWeeks(num);
            case DAY:
                return date.plusDays(num);
            case HOUR:
                return date.plusHours(num);
            case MIN:
                return date.plusMinutes(num);
            case SEC:
                return date.plusSeconds(num);
            default:
                throw new UnsupportedOperationException("Not implemented");
        }
    }
}
