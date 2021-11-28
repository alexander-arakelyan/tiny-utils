package org.bambrikii.expression.tiny.parser.vals;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;
import org.bambrikii.expression.tiny.parser.ValueParser;

public class SpaceParser implements ValueParser {
    @Override
    public boolean parse(ExpressionParserContext ctx) {
        int pos0 = ctx.getPos();
        int pos = pos0;
        while (!ctx.isEol(pos) && ctx.charAt(pos) == ' ') {
            pos++;
        }
        if (pos0 == pos) {
            return false;
        }
        ctx.setPos(pos);
        return false;
    }
}
