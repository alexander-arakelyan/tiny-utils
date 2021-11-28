package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.algo.MinusOperator;
import org.bambrikii.expression.tiny.algo.Operator;
import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public class MinusOperatorParser extends BaseOperatorParser {
    public MinusOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        Operator val1 = ctx.popVal();
        Operator val2 = ctx.popVal();
        ctx.pushVal(new MinusOperator(val2, val1));

        ctx.popParserOp();
    }
}
