package org.bambrikii.expression.tiny.algo.plus;

import org.bambrikii.expression.tiny.algo.OperatorOverload;
import org.bambrikii.expression.tiny.algo.PeriodElement;

import java.time.Instant;
import java.time.Period;
import java.util.List;

public class PlusInstantOverload implements OperatorOverload {
    @Override
    public boolean canAccept(Object... args) {
        return args[0] instanceof Instant;
    }

    @Override
    public Object eval(Object... args) {
        Instant date = (Instant) args[0];
        for (PeriodElement period : (List<PeriodElement>) args[1]) {
            int num = period.getNum();
            date = evalInstant(date, period, num);
        }
        return date;
    }

    private Instant evalInstant(Instant date, PeriodElement period, int num) {
        switch (period.getType()) {
            case YEAR:
                return date.plus(Period.ofYears(num));
            case MONTH:
                return date.plus(Period.ofMonths(num));
            case WEEK:
                return date.plus(Period.ofWeeks(num));
            case DAY:
                return date.plus(Period.ofDays(num));
            case SEC:
                return date.plusSeconds(num);
            default:
                throw new UnsupportedOperationException("Not implemented");
        }
    }
}
