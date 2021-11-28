package org.bambrikii.expression.tiny.parser.utils;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;

import static org.bambrikii.expression.tiny.parser.utils.NumericParserUtils.isNumeric;

public class StringParseUtils {
    public static char ESCAPE_CHAR = '\\';
    private static char[] SPECIAL_CHARS = new char[]{'.', '_', '-', '$', '#', '@', '+'};

    public static boolean isAlpha(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isChar(ExpressionParserContext ctx, int pos, char ch) {
        return ctx.charAt(pos) == ch;
    }

    public static int spaces(ExpressionParserContext ctx) {
        int pos = ctx.getPos();
        while (!ctx.isEol(pos) && ctx.charAt(pos++) == ' ') {
        }
        return pos;
    }

    public static boolean isStringEq(ExpressionParserContext ctx, int pos, String str) {
        int count = 0;
        while (!ctx.isEol(pos)) {
            if (ctx.charAt(pos + count) != str.charAt(count++)) {
                return false;
            }
        }
        return count == str.length();
    }

    public static boolean isAlphaNumeric(char ch) {
        return isAlpha(ch) || isNumeric(ch);
    }
}
