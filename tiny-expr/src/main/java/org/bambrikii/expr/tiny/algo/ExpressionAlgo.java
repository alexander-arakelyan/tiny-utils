package org.bambrikii.expr.tiny.algo;

public class ExpressionAlgo<R> {
    private Operator root;

    public ExpressionAlgo(Operator root) {
        this.root = root;
    }

    public R eval(ExpressionAlgoContext ctx) {
        return (R) root.eval(ctx);
    }
}
