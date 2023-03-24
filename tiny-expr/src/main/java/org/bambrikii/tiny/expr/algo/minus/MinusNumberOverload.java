package org.bambrikii.tiny.expr.algo.minus;

import org.bambrikii.tiny.expr.algo.OperatorOverload;

public class MinusNumberOverload implements OperatorOverload {
    @Override
    public boolean canAccept(Object... args) {
        return args[0] instanceof Number;
    }

    @Override
    public Object eval(Object... args) {
        Number val1 = (Number) args[0];
        Number val2 = (Number) args[1];
        return val1.doubleValue() - val2.doubleValue();
    }
}
