package org.bambrikii.expression.tiny.algo;

public class ClauseOperation implements Operation {
    private final Operation arg1;

    public ClauseOperation(Operation arg1) {
        this.arg1 = arg1;
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        return arg1.eval(ctx);
    }
}
