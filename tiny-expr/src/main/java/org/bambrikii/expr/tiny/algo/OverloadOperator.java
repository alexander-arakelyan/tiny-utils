package org.bambrikii.expr.tiny.algo;

import java.util.List;

public class OverloadOperator implements Operator {
    private final List<OperatorOverload> overloads;

    private final Operator arg1;
    private final Operator arg2;

    public OverloadOperator(
            List<OperatorOverload> overloads,
            Operator arg1,
            Operator arg2
    ) {
        this.overloads = overloads;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        Object val1 = arg1.eval(ctx);
        Object val2 = arg2.eval(ctx);
        for (OperatorOverload overload : overloads) {
            if (overload.canAccept(val1, val2)) {
                return overload.eval(val1, val2);
            }
        }
        throw new UnsupportedOperationException("Value [" + val1 + "] is not supported by [" + this.getClass().getName() + "] operator.");
    }
}
