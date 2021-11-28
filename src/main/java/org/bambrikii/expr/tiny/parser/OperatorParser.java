package org.bambrikii.expr.tiny.parser;

public interface OperatorParser extends ValueParser {
    int priority();

    boolean parse(ExpressionParserContext ctx);

    void shrink(ExpressionParserContext ctx);
}
