package org.bambrikii.diff.tiny;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareStringsTest {
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("str1ng", "triang", "trng"),
                Arguments.of("abcdef", "bdefg", "bdef")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    public void shouldMatch(String left, String right, String expected) {
        String result = new CompareStringsBfs().compare(left, right);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("args")
    public void shouldMatchArr(String left, String right, String expected) {
        String result = new CompareStringsArr().compare(left, right);

        assertThat(result).isEqualTo(expected);
    }
}
