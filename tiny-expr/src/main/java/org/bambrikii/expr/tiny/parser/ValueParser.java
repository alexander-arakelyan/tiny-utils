package org.bambrikii.expr.tiny.parser;

public interface ValueParser<T> {
    boolean parse(ExpressionParserContext ctx);
}
