package org.bambrikii.expression.tiny.parser.vals;

import org.bambrikii.expression.tiny.algo.LookupOperator;
import org.bambrikii.expression.tiny.parser.ExpressionParserContext;
import org.bambrikii.expression.tiny.parser.ValueParser;
import org.bambrikii.expression.tiny.parser.utils.StringParseUtils;

public class LookupParser implements ValueParser {
    @Override
    public boolean parse(ExpressionParserContext ctx) {
        int pos = ctx.getPos();
        if (ctx.isEol(pos) || ctx.charAt(pos) != '$') {
            return false;
        }
        pos++;
        StringBuilder sb = new StringBuilder();
        while (!ctx.isEol(pos)) {
            char ch = ctx.charAt(pos);
            if (!StringParseUtils.isAlphaNumeric(ch) && !StringParseUtils.isSpecialChars(ch)) {
                break;
            }
            pos++;
            sb.append(ch);
        }
        if (sb.length() == 0) {
            return false;
        }
        ctx.pushVal(new LookupOperator(sb.toString()));
        ctx.setPos(pos);
        return true;
    }
}
