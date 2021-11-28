package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;
import org.bambrikii.expression.tiny.parser.OperatorParser;
import org.bambrikii.expression.tiny.parser.utils.StringParseUtils;

public abstract class BaseOperatorParser implements OperatorParser {
    private final char ch;
    private final int priority;

    BaseOperatorParser(char ch, int priority) {
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
//        ctx.pushOp(this);
        ctx.setPos(pos);
        return true;
    }

    public abstract void shrink(ExpressionParserContext ctx);
}
