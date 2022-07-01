package org.bambrikii.expr.tiny.algo;

public interface Operator<P, Q, R> {
    R eval(ExpressionAlgoContext ctx);
}
