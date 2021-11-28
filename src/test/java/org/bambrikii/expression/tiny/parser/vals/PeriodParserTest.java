package org.bambrikii.expression.tiny.parser.vals;

import org.bambrikii.expression.tiny.algo.ConstantValue;
import org.bambrikii.expression.tiny.algo.ExpressionAlgoContext;
import org.bambrikii.expression.tiny.algo.Operator;
import org.bambrikii.expression.tiny.parser.ExpressionParserContext;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PeriodParserTest {
    @Test
    public void shouldParsePeriod() {
        ExpressionParserContext ctx = new ExpressionParserContext("1 day 3 months");
        boolean result = new PeriodParser().parse(ctx);

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
