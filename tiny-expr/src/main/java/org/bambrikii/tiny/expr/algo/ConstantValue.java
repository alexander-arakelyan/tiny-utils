package org.bambrikii.tiny.expr.algo;

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
