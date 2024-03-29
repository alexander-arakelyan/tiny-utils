package org.bambrikii.tiny.expr.parser;

import org.bambrikii.tiny.expr.algo.ExpressionAlgo;
import org.bambrikii.tiny.expr.parser.vals.TimePeriodParser;
import org.bambrikii.tiny.expr.parser.ops.CloseOperatorParser;
import org.bambrikii.tiny.expr.parser.ops.DivideOperatorParser;
import org.bambrikii.tiny.expr.parser.ops.MinusOperatorParser;
import org.bambrikii.tiny.expr.parser.ops.MultiplyOperatorParser;
import org.bambrikii.tiny.expr.parser.ops.OpenOperatorParser;
import org.bambrikii.tiny.expr.parser.ops.PlusOperatorParser;
import org.bambrikii.tiny.expr.parser.ops.ToUnixTimeOperatorParser;
import org.bambrikii.tiny.expr.parser.vals.LocalDateTimeParser;
import org.bambrikii.tiny.expr.parser.vals.LookupParser;
import org.bambrikii.tiny.expr.parser.vals.NumericParser;
import org.bambrikii.tiny.expr.parser.vals.SpaceParser;
import org.bambrikii.tiny.expr.parser.vals.StringParser;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {
    private List<ValueParser> parsers = new ArrayList<>();

    private ExpressionParser handler(ValueParser parser) {
        this.parsers.add(parser);
        return this;
    }

    private ExpressionParser handler(OperatorParser parser) {
        this.parsers.add(parser);
        return this;
    }

    public static ExpressionParser buildDefault() {
        int ops = 0;
        return new ExpressionParser()
                .handler(new SpaceParser())
                .handler(new LocalDateTimeParser())
                .handler(new TimePeriodParser())
                // operations
                .handler(new OpenOperatorParser('(', ops++))
                .handler(new CloseOperatorParser(')', ops++))
                .handler(new DivideOperatorParser('/', ops++))
                .handler(new MultiplyOperatorParser('*', ops++))
                .handler(new MinusOperatorParser('-', ops++))
                .handler(new PlusOperatorParser('+', ops++))
                .handler(new ToUnixTimeOperatorParser("unixtime", ops++))
                // values
                .handler(new NumericParser())
                .handler(new LookupParser())
                .handler(new StringParser());
    }

    public ExpressionAlgo compile(String expr) {
        ExpressionParserContext ctx = new ExpressionParserContext(expr);
        while (consume(ctx)) {
        }
        shrink(ctx);
        ExpressionAlgo algo = new ExpressionAlgo(ctx.getVals().pop());
        return algo;
    }

    private boolean consume(ExpressionParserContext ctx) {
        for (ValueParser parser : parsers) {
            if (parser.parse(ctx)) {
                if (parser instanceof OperatorParser) {
                    shrink(ctx, (OperatorParser) parser);
                }
                return true;
            }
        }
        return false;
    }

    private void shrink(ExpressionParserContext ctx, OperatorParser parser) {
        boolean isCloseClause = parser instanceof CloseOperatorParser;
        if (ctx.hasParserOps()) {
            OperatorParser lastParserOp = ctx.lastParserOp();
            boolean prevHasHigherPriority = lastParserOp.priority() < parser.priority();
            while ((ctx.hasParserOps() && prevHasHigherPriority || isCloseClause) && !(ctx.lastParserOp() instanceof OpenOperatorParser)) {
                ctx.lastParserOp().shrink(ctx);
            }
        }
        if (isCloseClause) {
            parser.shrink(ctx);
        } else {
            ctx.pushParserOp(parser);
        }
    }

    private void shrink(ExpressionParserContext ctx) {
        while (ctx.hasParserOps()) {
            ctx.lastParserOp().shrink(ctx);
        }
    }
}
