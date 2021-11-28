package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public class OpenOperatorParser extends BaseOperatorParser {
    public OpenOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
