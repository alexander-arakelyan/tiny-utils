package org.bambrikii.expr.tiny.parser.ops;

import org.bambrikii.expr.tiny.algo.Operator;
import org.bambrikii.expr.tiny.algo.minus.MinusOperator;
import org.bambrikii.expr.tiny.parser.ExpressionParserContext;

public class MinusOperatorParser extends CharBasedOperatorParser {
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
