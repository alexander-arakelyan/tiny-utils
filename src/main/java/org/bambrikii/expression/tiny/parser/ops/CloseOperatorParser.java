package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.algo.ClauseOperator;
import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public class CloseOperatorParser extends BaseOperatorParser {
    public CloseOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        ctx.pushVal(new ClauseOperator(ctx.popVal()));

        ctx.popParserOp();// should be open clause
    }
}
