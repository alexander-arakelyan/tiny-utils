package org.bambrikii.tiny.expr.parser.ops;

import org.bambrikii.tiny.expr.algo.ToUnixTimeOperator;
import org.bambrikii.tiny.expr.parser.ExpressionParserContext;

public class ToUnixTimeOperatorParser extends StringBasedOperatorParser {
    public ToUnixTimeOperatorParser(String str, int priority) {
        super(str, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        ctx.pushVal(new ToUnixTimeOperator(ctx.popVal()));

        ctx.popParserOp();
    }
}
