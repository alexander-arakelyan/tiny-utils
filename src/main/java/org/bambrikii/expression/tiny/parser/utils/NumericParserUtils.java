package org.bambrikii.expression.tiny.parser.utils;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

public class NumericParserUtils {
    public static boolean isNumeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    public static Number nextDigits(ExpressionParserContext ctx, int pos, int digits) {
        int num = 0;
        int pos0 = pos;
        while (!ctx.isEol(pos0)) {
            char ch = ctx.charAt(pos0++);
            if (isNumeric(ch)) {
                num = num * 10 + (ch - '0');
            }
        }
        if (pos0 - pos != digits) {
            return null;
        }
        return num;
    }
}
