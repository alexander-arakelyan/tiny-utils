package org.bambrikii.tiny.expr.parser.ops;

import org.bambrikii.tiny.expr.algo.Operator;
import org.bambrikii.tiny.expr.algo.OperatorOverload;
import org.bambrikii.tiny.expr.algo.OverloadOperator;
import org.bambrikii.tiny.expr.algo.plus.PlusInstantOverload;
import org.bambrikii.tiny.expr.algo.plus.PlusLocalDateTimeOverload;
import org.bambrikii.tiny.expr.algo.plus.PlusNumberOverload;
import org.bambrikii.tiny.expr.algo.plus.PlusStringOverload;
import org.bambrikii.tiny.expr.parser.ExpressionParserContext;

import java.util.List;

public class PlusOperatorParser extends CharBasedOperatorParser {
    private final List<OperatorOverload> overloads = List.of(
            new PlusStringOverload(),
            new PlusInstantOverload(),
            new PlusLocalDateTimeOverload(),
            new PlusNumberOverload()
    );

    public PlusOperatorParser(char ch, int priority) {
        super(ch, priority);
    }

    @Override
    public void shrink(ExpressionParserContext ctx) {
        Operator val1 = ctx.popVal();
        Operator val2 = ctx.popVal();
        ctx.pushVal(new OverloadOperator(overloads, val2, val1));

        ctx.popParserOp();
    }
}
