package org.bambrikii.tiny.expr.parser.utils;

import org.bambrikii.tiny.expr.parser.ExpressionParserContext;

public class InstantParserUtils {
    public static boolean nextDelimiter(ExpressionParserContext ctx, int pos, char c) {
        return !ctx.isEol(pos) && StringParseUtils.isChar(ctx, pos, c);
    }
}
