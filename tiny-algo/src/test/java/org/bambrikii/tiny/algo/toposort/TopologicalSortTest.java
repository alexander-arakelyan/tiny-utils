package org.bambrikii.tiny.algo.toposort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TopologicalSortTest {
    @Test
    void shouldSort() {
        // given, when
        var actual = new TopologicalSort<Integer>()
                .dep(1, 2)
                .dep(2, 3)
                .dep(1, 4)
                .dep(1, 5)
                .dep(3, 4)
                .dep(3, 5)
                .sort();

        // then
        assertThat(actual).isEqualTo(List.of(1, 2, 3, 4, 5));
    }
}
