package org.bambrikii.expression.tiny.algo;

import java.util.ArrayList;
import java.util.List;

public class PeriodValue implements Operator {
    private List<PeriodElement> values = new ArrayList<>();

    public void addValue(int num, PeriodType type) {
        values.add(new PeriodElement(num, type));
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        return values;
    }
}
