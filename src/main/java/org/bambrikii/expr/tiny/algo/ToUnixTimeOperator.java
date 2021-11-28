package org.bambrikii.expr.tiny.algo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ToUnixTimeOperator implements Operator {
    private final Operator arg1;

    public ToUnixTimeOperator(Operator arg1) {
        this.arg1 = arg1;
    }

    @Override
    public Object eval(ExpressionAlgoContext ctx) {
        Object val = arg1.eval(ctx);
        if (val instanceof Instant) {
            return ((Instant) val).getEpochSecond();
        }
        if (val instanceof LocalDateTime) {
            return ((LocalDateTime) val).atZone(ZoneId.systemDefault()).toEpochSecond();
        }
        throw new UnsupportedOperationException("Type [" + val + "] conversion to unix timestamp is not supported.");
    }
}
