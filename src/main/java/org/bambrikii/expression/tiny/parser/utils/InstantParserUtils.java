package org.bambrikii.expression.tiny.parser.utils;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

import static org.bambrikii.expression.tiny.parser.utils.StringParseUtils.isChar;

public class InstantParserUtils {
    public static boolean nextDelimiter(ExpressionParserContext ctx, int pos, char c) {
        return !ctx.isEol(pos) && isChar(ctx, pos, c);
    }
}
