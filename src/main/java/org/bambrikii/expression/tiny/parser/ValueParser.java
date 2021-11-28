package org.bambrikii.expression.tiny.parser;

public interface ValueParser<T> {
    boolean parse(ExpressionParserContext ctx);
}
