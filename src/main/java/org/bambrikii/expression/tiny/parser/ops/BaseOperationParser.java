package org.bambrikii.expression.tiny.parser.ops;

import org.bambrikii.expression.tiny.parser.ExpressionParserContext;
import org.bambrikii.expression.tiny.parser.OperationParser;
import org.bambrikii.expression.tiny.parser.utils.StringParseUtils;

public abstract class BaseOperationParser implements OperationParser {
    private final char ch;
    private final int priority;

    BaseOperationParser(char ch, int priority) {
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
