package org.bambrikii.expression.tiny.algo;

public class ConstantValue implements Operation {
    private Object value;

    public ConstantValue(Object value) {
        this.value = value;
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        return value;
    }
}
