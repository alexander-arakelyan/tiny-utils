package org.bambrikii.expression.tiny.algo;

public interface Operator<P, Q, R> {
    R eval(ExpressionAlgoContext ctx);
}
