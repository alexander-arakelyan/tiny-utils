package org.bambrikii.tiny.algo.combinatorics.permutations;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.bambrikii.tiny.algo.utils.ArrayUtils.swap;

public class Permutations<T> {
    private final Consumer<T[]>[] consumers;

    public Permutations(Consumer<T[]>... consumers) {
        this.consumers = consumers;
    }

    public void permute(T[] arr) {
        permute(arr, 0);
    }

    private void permute(T[] arr, int k) {
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
