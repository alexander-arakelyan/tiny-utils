package org.bambrikii.tiny.expr.parser.ops;

import org.bambrikii.tiny.expr.algo.MultiplyOperator;
import org.bambrikii.tiny.expr.algo.Operator;
import org.bambrikii.tiny.expr.parser.ExpressionParserContext;

public class MultiplyOperatorParser extends CharBasedOperatorParser {
    public MultiplyOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        Operator val1 = ctx.popVal();
        Operator val2 = ctx.popVal();
        ctx.pushVal(new MultiplyOperator(val2, val1));

        ctx.popParserOp();
    }
}
