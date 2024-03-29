package org.bambrikii.tiny.expr.algo.plus;

import org.bambrikii.tiny.expr.algo.OperatorOverload;

import java.util.Objects;

public class PlusNumberOverload implements OperatorOverload {
    @Override
    public boolean canAccept(Object... args) {
        return args[0] instanceof Number;
    }

    @Override
    public Object eval(Object... args) {
        Number num1 = (Number) args[0];
        Number num2 = (Number) args[1];
        Objects.requireNonNull(num1);
        Objects.requireNonNull(num2);

        return num1.doubleValue() + num2.doubleValue();
    }
}
