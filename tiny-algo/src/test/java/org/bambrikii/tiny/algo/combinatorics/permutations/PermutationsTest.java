package org.bambrikii.tiny.algo.combinatorics.permutations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationsTest {
    @Test
    public void shouldPermute() {
        var actual = new ArrayList<int[]>();
        new Permutations(arr -> {
            int[] copy = new int[arr.length];
            System.arraycopy(arr, 0, copy, 0, arr.length);
            actual.add(copy);
        }).permute(new int[]{1, 2, 3});

        Assertions.assertThat(actual).hasSameElementsAs(List.of(
                new int[]{1, 2, 3},
                new int[]{1, 3, 2},
                new int[]{2, 1, 3},
                new int[]{2, 3, 1},
                new int[]{3, 2, 1},
                new int[]{3, 1, 2}
        ));
    }
}
