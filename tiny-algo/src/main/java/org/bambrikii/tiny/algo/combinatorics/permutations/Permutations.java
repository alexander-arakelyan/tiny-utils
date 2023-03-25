package org.bambrikii.tiny.algo.combinatorics.permutations;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.bambrikii.tiny.algo.utils.ArrayUtils.swap;

public class Permutations {
    private final Consumer<int[]>[] consumers;

    public Permutations(Consumer<int[]>... consumers) {
        this.consumers = consumers;
    }

    public void permute(int[] arr) {
        permute(arr, 0);
    }

    private void permute(int[] arr, int k) {
        if (k == arr.length) {
            Arrays
                    .stream(consumers)
                    .forEach(consumer -> consumer.accept(arr));
        }
        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            permute(arr, k + 1);
            swap(arr, i, k);
        }
    }
}
