package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.algo.ClauseOperation;
import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public class CloseOperationParser extends BaseOperationParser {
    public CloseOperationParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        ctx.pushVal(new ClauseOperation(ctx.popVal()));

        ctx.popParserOp();// should be open clause
    }
}
