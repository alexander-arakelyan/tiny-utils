package org.bambrikii.tiny.expr.parser.vals;

import org.bambrikii.tiny.expr.algo.ConstantValue;
import org.bambrikii.tiny.expr.parser.ExpressionParserContext;
import org.bambrikii.tiny.expr.parser.ValueParser;
import org.bambrikii.tiny.expr.parser.utils.StringParseUtils;

import java.util.ArrayList;
import java.util.List;

public class StringParser implements ValueParser<String> {
    @Override
    public boolean parse(ExpressionParserContext ctx) {
        int pos = ctx.getPos();
        int pos0 = pos;
        List<Character> chars = new ArrayList<>();
        if (ctx.isEol(pos)) {
            return false;
        }
        char ch = ctx.charAt(pos);
        if (ch == StringParseUtils.ESCAPE_CHAR) {
            pos++;
            if (ctx.isEol(pos)) {
                return false;
            }
            addChar(ctx, pos, chars);
            pos++;
        }
        if (ctx.isEol(pos)) {
            return false;
        }
        if (!StringParseUtils.isAlpha(ch)) {
            return false;
        }
        addChar(ctx, pos, chars);
        pos++;
        while (!ctx.isEol(pos)) {
            ch = ctx.charAt(pos);
            if (ch == StringParseUtils.ESCAPE_CHAR) {
                pos++;
                if (ctx.isEol(pos)) {
                    return false;
                }
                addChar(ctx, pos, chars);
                pos++;
            }
            if (!StringParseUtils.isAlphaNumeric(ch)) {
                break;
            }
            addChar(ctx, pos, chars);
            pos++;
        }
        if (pos0 == pos) {
            return false;
        }
        int size = chars.size();
        char[] charsPrimitive = new char[size];
        for (int i = 0; i < size; i++) {
            charsPrimitive[i] = chars.get(i);
        }
        ctx.pushVal(new ConstantValue(new String(charsPrimitive)));
        ctx.setPos(pos);
        return true;
    }

    private void addChar(ExpressionParserContext ctx, int pos, List<Character> chars) {
        chars.add(ctx.charAt(pos));
    }
}
