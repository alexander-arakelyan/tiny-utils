package org.bambrikii.tiny.expr.parser.ops;

import org.bambrikii.tiny.expr.algo.ClauseOperator;
import org.bambrikii.tiny.expr.parser.ExpressionParserContext;

public class CloseOperatorParser extends CharBasedOperatorParser {
    public CloseOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        ctx.pushVal(new ClauseOperator(ctx.popVal()));

        ctx.popParserOp();// should be open clause
    }
}
