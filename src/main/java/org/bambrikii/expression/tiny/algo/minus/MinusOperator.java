package org.bambrikii.expression.tiny.algo.minus;

import org.bambrikii.expression.tiny.algo.ExpressionAlgoContext;
import org.bambrikii.expression.tiny.algo.Operator;
import org.bambrikii.expression.tiny.algo.OperatorOverload;

import java.util.List;

public class MinusOperator implements Operator {
    private final Operator arg1;
    private final Operator arg2;
    private List<OperatorOverload> overloads = List.of(
            new MinusNumberOverload(),
            new MinusInstantOverload(),
            new MinusLocalDateTimeOverload()
    );

    public MinusOperator(Operator arg1, Operator arg2) {
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
        throw new UnsupportedOperationException("Value [" + val1 + "] does not support minus operator.");
    }
}
