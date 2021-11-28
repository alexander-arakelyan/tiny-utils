package org.bambrikii.expr.tiny.algo.minus;

import org.bambrikii.expr.tiny.algo.OperatorOverload;
import org.bambrikii.expr.tiny.algo.timeperiod.TimePeriodElement;

import java.time.LocalDateTime;
import java.util.List;

public class MinusLocalDateTimeOverload implements OperatorOverload {
    @Override
    public boolean canAccept(Object... args) {
        return args[0] instanceof LocalDateTime;
    }

    @Override
    public Object eval(Object... args) {
        LocalDateTime date = (LocalDateTime) args[0];
        for (TimePeriodElement period : (List<TimePeriodElement>) args[1]) {
            date = evalDate(date, period);
        }
        return date;
    }

    private LocalDateTime evalDate(LocalDateTime date, TimePeriodElement period) {
        int num = period.getNum();
        switch (period.getType()) {
            case YEAR:
                return date.minusYears(num);
            case MONTH:
                return date.minusMonths(num);
            case WEEK:
                return date.minusWeeks(num);
            case DAY:
                return date.minusDays(num);
            case HOUR:
                return date.minusHours(num);
            case MIN:
                return date.minusMinutes(num);
            case SEC:
                return date.minusSeconds(num);
            default:
                throw new UnsupportedOperationException("Not implemented");
        }
    }
}
