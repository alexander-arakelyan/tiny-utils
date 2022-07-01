package org.bambrikii.expr.tiny.parser.ops;

import org.bambrikii.expr.tiny.algo.ToUnixTimeOperator;
import org.bambrikii.expr.tiny.parser.ExpressionParserContext;

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
