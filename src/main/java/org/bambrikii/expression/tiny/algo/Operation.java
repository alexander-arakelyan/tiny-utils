package org.bambrikii.expression.tiny.algo;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public interface Operation<P, Q, R> {
    R eval(ExpressionAlgoContext ctx);

    interface OperationBuilder {
        Operation build(ExpressionParserContext ctx);
    }
}
