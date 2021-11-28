package org.bambrikii.expression.tiny.parser;

public interface OperationParser extends ValueParser {
    int priority();

    boolean parse(ExpressionParserContext ctx);

    void shrink(ExpressionParserContext ctx);
}
