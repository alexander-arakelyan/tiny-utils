package org.bambrikii.tiny.expr.algo;

import java.util.function.Function;

public class ExpressionAlgoContext {
    private final Function lookup;

    public ExpressionAlgoContext() {
        this(o -> null);
    }

    public ExpressionAlgoContext(Function lookup) {
        this.lookup = lookup;
    }

    public Operator popVal() {
        return null;
    }

    public Object lookup(Object name) {
        return lookup.apply(name);
    }
}
