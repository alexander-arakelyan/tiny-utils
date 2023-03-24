package org.bambrikii.tiny.expr.parser.ops;

import org.bambrikii.tiny.expr.parser.ExpressionParserContext;
import org.bambrikii.tiny.expr.parser.OperatorParser;
import org.bambrikii.tiny.expr.parser.utils.StringParseUtils;

public abstract class CharBasedOperatorParser implements OperatorParser {
    private final char ch;
    private final int priority;

    CharBasedOperatorParser(char ch, int priority) {
        this.ch = ch;
        this.priority = priority;
    }

    public int priority() {
        return priority;
    }

    @Override
    public boolean parse(ExpressionParserContext ctx) {
        int pos = ctx.getPos();
        if (ctx.isEol(pos) || !StringParseUtils.isChar(ctx, pos++, ch)) {
            return false;
        }

        ctx.setPos(pos);
        return true;
    }

    public abstract void shrink(ExpressionParserContext ctx);
}
