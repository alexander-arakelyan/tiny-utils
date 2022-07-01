package org.bambrikii.expr.tiny.parser.ops;

import org.bambrikii.expr.tiny.parser.ExpressionParserContext;
import org.bambrikii.expr.tiny.parser.OperatorParser;

public abstract class StringBasedOperatorParser implements OperatorParser {
    private final String str;
    private final int priority;

    public StringBasedOperatorParser(String str, int priority) {
        this.str = str;
        this.priority = priority;
    }

    public int priority() {
        return priority;
    }

    @Override
    public boolean parse(ExpressionParserContext ctx) {
        int pos = ctx.getPos();
        int i;
        for (i = 0; i < str.length() && !ctx.isEol(pos + i) && str.charAt(i) == ctx.charAt(pos + i); i++) {
        }

        if (i != str.length()) {
            return false;
        }

        ctx.setPos(pos + i);
        return true;
    }
}
