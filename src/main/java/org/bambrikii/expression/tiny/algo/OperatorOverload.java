package org.bambrikii.expression.tiny.algo;

public interface OperatorOverload {
    boolean canAccept(Object... args);

    Object eval(Object... args);
}
