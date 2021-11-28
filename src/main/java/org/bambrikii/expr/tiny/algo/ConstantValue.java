package org.bambrikii.expr.tiny.algo;

public class ConstantValue implements Operator {
    private Object value;

    public ConstantValue(Object value) {
        this.value = value;
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        return value;
    }
}
