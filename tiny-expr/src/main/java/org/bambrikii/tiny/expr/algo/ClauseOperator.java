package org.bambrikii.tiny.expr.algo;

public class ClauseOperator implements Operator {
    private final Operator arg1;

    public ClauseOperator(Operator arg1) {
        this.arg1 = arg1;
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        return arg1.eval(ctx);
    }
}
