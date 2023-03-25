package org.bambrikii.tiny.algo.combinatorics.permutations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PermutationsTest {
    @Test
    public void shouldPermuteIntegers() {
        var actual = new ArrayList<Integer[]>();
        new Permutations((Consumer<Integer[]>) arr -> {
            Integer[] copy = new Integer[arr.length];
            System.arraycopy(arr, 0, copy, 0, arr.length);
            actual.add(copy);
        }).permute(new Integer[]{1, 2, 3});

        Assertions.assertThat(actual).hasSameElementsAs(List.of(
                new Integer[]{1, 2, 3},
                new Integer[]{1, 3, 2},
                new Integer[]{2, 1, 3},
                new Integer[]{2, 3, 1},
                new Integer[]{3, 2, 1},
                new Integer[]{3, 1, 2}
        ));
    }

    @Test
    public void shouldPermuteCharacters() {
        var actual = new ArrayList<Character[]>();
        new Permutations((Consumer<Character[]>) arr -> {
            Character[] copy = new Character[arr.length];
            System.arraycopy(arr, 0, copy, 0, arr.length);
            actual.add(copy);
        }).permute(new Character[]{'a', 'b', 'c'});

        Assertions.assertThat(actual).hasSameElementsAs(List.of(
                new Character[]{'a', 'b', 'c'},
                new Character[]{'a', 'c', 'b'},
                new Character[]{'b', 'a', 'c'},
                new Character[]{'b', 'c', 'a'},
                new Character[]{'c', 'a', 'b'},
                new Character[]{'c', 'b', 'a'}
        ));
    }
}
