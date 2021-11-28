package org.bambrikii.expr.tiny.algo.timeperiod;

import org.bambrikii.expr.tiny.algo.ExpressionAlgoContext;
import org.bambrikii.expr.tiny.algo.Operator;

import java.util.ArrayList;
import java.util.List;

public class TimePeriodValue implements Operator {
    private List<TimePeriodElement> values = new ArrayList<>();

    public void addValue(int num, TimePeriodType type) {
        values.add(new TimePeriodElement(num, type));
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        return values;
    }
}
