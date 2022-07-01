package org.bambrikii.expr.tiny.algo;

public interface OperatorOverload {
    boolean canAccept(Object... args);

    Object eval(Object... args);
}
