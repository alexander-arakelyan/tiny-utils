package org.bambrikii.expression.tiny.algo.plus;

import org.bambrikii.expression.tiny.algo.OperatorOverload;

public class PlusNumberOverload implements OperatorOverload {
    @Override
    public boolean canAccept(Object... args) {
        return args[0] instanceof Number;
    }

    @Override
    public Object eval(Object... args) {
        Number num1 = (Number) args[0];
        Number num2 = (Number) args[1];
        return num1.doubleValue() + num2.doubleValue();
    }
}
