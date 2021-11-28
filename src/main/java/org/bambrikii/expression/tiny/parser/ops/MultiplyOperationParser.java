package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.algo.MultiplyOperation;
import org.bambrikii.expression.tiny.algo.Operation;
import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public class MultiplyOperationParser extends BaseOperationParser {
    public MultiplyOperationParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        Operation val1 = ctx.popVal();
        Operation val2 = ctx.popVal();
        ctx.pushVal(new MultiplyOperation(val2, val1));

        ctx.popParserOp();
    }
}
