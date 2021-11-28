package org.bambrikii.expr.tiny.parser.ops;

import org.bambrikii.expr.tiny.algo.Operator;
import org.bambrikii.expr.tiny.parser.ExpressionParserContext;
import org.bambrikii.expr.tiny.algo.plus.PlusOperator;

public class PlusOperatorParser extends CharBasedOperatorParser {
    public PlusOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        Operator val1 = ctx.popVal();
        Operator val2 = ctx.popVal();
        ctx.pushVal(new PlusOperator(val2, val1));

        ctx.popParserOp();
    }
}
