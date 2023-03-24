package org.bambrikii.tiny.expr.parser.ops;

import org.bambrikii.tiny.expr.parser.ExpressionParserContext;

public class OpenOperatorParser extends CharBasedOperatorParser {
    public OpenOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
