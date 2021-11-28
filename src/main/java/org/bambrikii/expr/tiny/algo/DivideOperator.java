package org.bambrikii.expr.tiny.algo;

public class DivideOperator implements Operator {
    private final Operator arg1;
    private final Operator arg2;

    public DivideOperator(Operator arg1, Operator arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public Number eval(ExpressionAlgoContext ctx) {
        Number val1 = (Number) arg1.eval(ctx);
        Number val2 = (Number) arg2.eval(ctx);
        return val1.doubleValue() / val2.doubleValue();
    }
}
