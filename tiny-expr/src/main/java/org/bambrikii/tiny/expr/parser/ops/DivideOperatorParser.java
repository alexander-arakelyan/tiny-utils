package org.bambrikii.tiny.expr.parser.ops;

import org.bambrikii.tiny.expr.algo.DivideOperator;
import org.bambrikii.tiny.expr.algo.Operator;
import org.bambrikii.tiny.expr.parser.ExpressionParserContext;

public class DivideOperatorParser extends CharBasedOperatorParser {
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
