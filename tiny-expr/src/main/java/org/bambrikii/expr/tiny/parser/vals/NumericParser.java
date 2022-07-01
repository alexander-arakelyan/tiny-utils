package org.bambrikii.expr.tiny.parser.vals;

import org.bambrikii.expr.tiny.algo.ConstantValue;
import org.bambrikii.expr.tiny.parser.ExpressionParserContext;
import org.bambrikii.expr.tiny.parser.ValueParser;
import org.bambrikii.expr.tiny.parser.utils.NumericParserUtils;
import org.bambrikii.expr.tiny.parser.utils.StringParseUtils;

public class NumericParser implements ValueParser<Number> {
    @Override
    public boolean parse(ExpressionParserContext ctx) {
        int whole = 0;
        int pos = ctx.getPos();
        int posWhole = pos;
        while (!ctx.isEol(posWhole)) {
            char ch = ctx.charAt(posWhole);
            if (!NumericParserUtils.isNumeric(ch)) {
                break;
            }
            whole = whole * 10 + (ch - '0');
            posWhole++;
        }

        if (ctx.isEol(posWhole) || !StringParseUtils.isChar(ctx, posWhole, '.')) {
            if (posWhole == pos) {
                return false;
            }
            ctx.pushVal(new ConstantValue(Integer.valueOf(whole)));
            ctx.setPos(posWhole);
            return true;
        }

        int posFraction = posWhole + 1;
        double fraction = 0;
        int div = 10;
        while (!ctx.isEol(posFraction)) {
            char ch = ctx.charAt(posFraction++);
            if (!NumericParserUtils.isNumeric(ch)) {
                break;
            }
            fraction = fraction + (ch - '0') / div;
            div *= 10;
        }
        if (posFraction == pos + 1) {
            if (posWhole == pos) {
                return false;
            }
            ctx.pushVal(new ConstantValue(Integer.valueOf(whole)));
        } else {
            ctx.pushVal(new ConstantValue(Double.valueOf(whole + fraction)));
        }
        ctx.setPos(posWhole);
        return true;
    }
}
