package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.algo.DivideOperator;
import org.bambrikii.expression.tiny.algo.Operator;
import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public class DivideOperatorParser extends BaseOperatorParser {
    public DivideOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        Operator val1 = ctx.popVal();
        Operator val2 = ctx.popVal();
        ctx.pushVal(new DivideOperator(val2, val1));

        ctx.popParserOp();
    }
}
