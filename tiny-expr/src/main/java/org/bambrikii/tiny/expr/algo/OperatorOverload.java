package org.bambrikii.tiny.expr.algo;

public interface OperatorOverload {
    boolean canAccept(Object... args);

    Object eval(Object... args);
}
