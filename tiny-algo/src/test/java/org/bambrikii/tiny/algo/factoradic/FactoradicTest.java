package org.bambrikii.tiny.algo.factoradic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FactoradicTest {
    @Test
    public void shouldConvertToDecimal() {
        var actual = Factoradic.toDecimal("abcdef"); // when

        assertThat(actual).isEqualTo(0); // then
    }

    @Test
    public void shouldConvertToDecimal1() {
        var actual = Factoradic.toDecimal("abcdfe"); // when

        assertThat(actual).isEqualTo(1); // then
    }

    @Test
    public void shouldConvertToDecimal719() {
        var actual = Factoradic.toDecimal("fedcba"); // when

        assertThat(actual).isEqualTo(719); // then
    }

    @Test
    public void shouldConvertToFactoradic718() {
        var actual = Factoradic.toFactoradic("abcdef", 718); // when

        assertThat(actual).isEqualTo("fedcab"); // then
    }

    @Test
    public void shouldConvertToFactoradic719() {
        var actual = Factoradic.toFactoradic("abcdef", 719); // when

        assertThat(actual).isEqualTo("fedcba"); // then
    }
}
