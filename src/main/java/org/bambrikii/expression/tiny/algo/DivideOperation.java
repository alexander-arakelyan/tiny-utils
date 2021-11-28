package org.bambrikii.expression.tiny.algo;

public class DivideOperation implements Operation {
    private final Operation arg1;
    private final Operation arg2;

    public DivideOperation(Operation arg1, Operation arg2) {
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
