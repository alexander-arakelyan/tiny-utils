package org.bambrikii.expression.tiny.algo;

public class ExpressionAlgo<R> {
    private Operation root;

    public ExpressionAlgo(Operation root) {
        this.root = root;
    }

    public R eval(ExpressionAlgoContext ctx) {
        return (R) root.eval(ctx);
    }
}
