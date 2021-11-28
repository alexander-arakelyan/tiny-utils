package org.bambrikii.expression.tiny.algo.minus;

import org.bambrikii.expression.tiny.algo.ExpressionAlgoContext;
import org.bambrikii.expression.tiny.algo.Operator;

public class MultiplyOperator implements Operator {
    private Operator arg1;
    private Operator arg2;

    public MultiplyOperator(Operator arg1, Operator arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public Number eval(ExpressionAlgoContext ctx) {
        Number val1 = (Number) arg1.eval(ctx);
        Number val2 = (Number) arg2.eval(ctx);
        return val1.doubleValue() * val2.doubleValue();
    }
}
