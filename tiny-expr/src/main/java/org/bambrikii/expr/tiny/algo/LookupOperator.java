package org.bambrikii.expr.tiny.algo;

public class LookupOperator implements Operator {
    private final String name;

    public LookupOperator(String name) {
        this.name = name;
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        return ctx.lookup(name);
    }
}
