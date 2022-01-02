package org.bambrikii.expr.tiny.parser.ops;

import org.bambrikii.expr.tiny.algo.Operator;
import org.bambrikii.expr.tiny.algo.OperatorOverload;
import org.bambrikii.expr.tiny.algo.OverloadOperator;
import org.bambrikii.expr.tiny.algo.plus.PlusInstantOverload;
import org.bambrikii.expr.tiny.algo.plus.PlusLocalDateTimeOverload;
import org.bambrikii.expr.tiny.algo.plus.PlusNumberOverload;
import org.bambrikii.expr.tiny.algo.plus.PlusStringOverload;
import org.bambrikii.expr.tiny.parser.ExpressionParserContext;

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
