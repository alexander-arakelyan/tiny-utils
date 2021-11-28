package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public class OpenOperationParser extends BaseOperationParser {
    public OpenOperationParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
