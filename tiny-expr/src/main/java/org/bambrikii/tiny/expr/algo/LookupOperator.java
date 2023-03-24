package org.bambrikii.tiny.expr.algo;

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
