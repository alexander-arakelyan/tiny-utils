package org.bambrikii.expr.tiny.parser.ops;

import org.bambrikii.expr.tiny.algo.Operator;
import org.bambrikii.expr.tiny.algo.OperatorOverload;
import org.bambrikii.expr.tiny.algo.OverloadOperator;
import org.bambrikii.expr.tiny.algo.minus.MinusInstantOverload;
import org.bambrikii.expr.tiny.algo.minus.MinusLocalDateTimeOverload;
import org.bambrikii.expr.tiny.algo.minus.MinusNumberOverload;
import org.bambrikii.expr.tiny.parser.ExpressionParserContext;

import java.util.List;

public class MinusOperatorParser extends CharBasedOperatorParser {
    private final List<OperatorOverload> overloads = List.of(
            new MinusNumberOverload(),
            new MinusInstantOverload(),
            new MinusLocalDateTimeOverload()
    );

    public MinusOperatorParser(char ch, int priority) {
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
