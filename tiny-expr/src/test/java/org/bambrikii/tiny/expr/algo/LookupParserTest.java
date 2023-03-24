package org.bambrikii.tiny.expr.algo;

import org.bambrikii.tiny.expr.parser.ExpressionParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LookupParserTest {
    @Test
    public void shouldEval() {
        Object val = ExpressionParser.buildDefault()
                .compile("1 + $param1")
                .eval(new ExpressionAlgoContext(o -> {
                    if ("param1".equals(o)) {
                        return 2;
                    }
                    return null;
                }));

        assertThat(val).isEqualTo(3.0);
    }
}
