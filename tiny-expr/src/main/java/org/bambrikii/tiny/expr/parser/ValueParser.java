package org.bambrikii.tiny.expr.parser;

public interface ValueParser<T> {
    boolean parse(ExpressionParserContext ctx);
}
