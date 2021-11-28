package org.bambrikii.expression.tiny.algo.plus;

import org.bambrikii.expression.tiny.algo.OperatorOverload;

public class PlusStringOverload implements OperatorOverload {
    @Override
    public boolean canAccept(Object... args) {
        return args[0] instanceof String || args[1] instanceof String;
    }

    @Override
    public Object eval(Object... args) {
        Object val1 = args[0];
        Object val2 = args[1];
        return String.valueOf(val1) + val2;
    }
}
