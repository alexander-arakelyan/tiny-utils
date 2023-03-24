package org.bambrikii.tiny.expr.parser.vals;

import org.bambrikii.tiny.expr.algo.ConstantValue;
import org.bambrikii.tiny.expr.algo.Operator;
import org.bambrikii.tiny.expr.parser.ExpressionParserContext;
import org.bambrikii.tiny.expr.algo.ExpressionAlgoContext;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TimePeriodParserTest {
    @Test
    public void shouldParsePeriod() {
        ExpressionParserContext ctx = new ExpressionParserContext("1 day 3 months");
        boolean result = new TimePeriodParser().parse(ctx);

        assertThat(result).isTrue();

        Operator val = ctx.popVal();
        assertThat(val).isInstanceOf(ConstantValue.class);
        ExpressionAlgoContext ctx2 = new ExpressionAlgoContext();
        Object eval = val.eval(ctx2);
        assertThat(eval).isInstanceOf(List.class);
        List list = (List) eval;
        assertThat(list).hasSize(2);
    }
}
