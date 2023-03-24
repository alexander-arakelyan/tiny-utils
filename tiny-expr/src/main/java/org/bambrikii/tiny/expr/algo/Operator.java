package org.bambrikii.tiny.expr.algo;

public interface Operator<P, Q, R> {
    R eval(ExpressionAlgoContext ctx);
}
