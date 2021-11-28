package org.bambrikii.expression.tiny.parser;

import org.bambrikii.expression.tiny.algo.ExpressionAlgo;
import org.bambrikii.expression.tiny.parser.ops.CloseOperationParser;
import org.bambrikii.expression.tiny.parser.ops.DivideOperationParser;
import org.bambrikii.expression.tiny.parser.ops.MinusOperationParser;
import org.bambrikii.expression.tiny.parser.ops.MultiplyOperationParser;
import org.bambrikii.expression.tiny.parser.ops.OpenOperationParser;
import org.bambrikii.expression.tiny.parser.ops.PlusOperationParser;
import org.bambrikii.expression.tiny.parser.vals.InstantParser;
import org.bambrikii.expression.tiny.parser.vals.NumericParser;
import org.bambrikii.expression.tiny.parser.vals.SpaceParser;
import org.bambrikii.expression.tiny.parser.vals.StringParser;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {
    private List<ValueParser> parsers = new ArrayList<>();

    private ExpressionParser handler(ValueParser parser) {
        this.parsers.add(parser);
        return this;
    }

    private ExpressionParser handler(OperationParser parser) {
        this.parsers.add(parser);
        return this;
    }

    public static ExpressionParser buildDefault() {
        int ops = 0;
        return new ExpressionParser()
                .handler(new SpaceParser())
                // operations
                .handler(new OpenOperationParser('(', ops++))
                .handler(new CloseOperationParser(')', ops++))
                .handler(new DivideOperationParser('/', ops++))
                .handler(new MultiplyOperationParser('*', ops++))
                .handler(new MinusOperationParser('-', ops++))
                .handler(new PlusOperationParser('+', ops++))
                // values
                .handler(new InstantParser())
                .handler(new NumericParser())
                .handler(new StringParser());
    }

    public ExpressionAlgo consume(String expr) {
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
                if (parser instanceof OperationParser) {
                    shrink(ctx, (OperationParser) parser);
                }
                return true;
            }
        }
        return false;
    }

    private void shrink(ExpressionParserContext ctx, OperationParser parser) {
        boolean isCloseClause = parser instanceof CloseOperationParser;
        if (ctx.hasParserOps()) {
            OperationParser lastParserOp = ctx.lastParserOp();
            boolean prevHasHigherPriority = lastParserOp.priority() < parser.priority();
            while ((ctx.hasParserOps() && prevHasHigherPriority || isCloseClause) && !(ctx.lastParserOp() instanceof OpenOperationParser)) {
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
