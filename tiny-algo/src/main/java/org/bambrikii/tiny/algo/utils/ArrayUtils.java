package org.bambrikii.tiny.algo.utils;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static <T> void swap(T[] arr, int left, int right) {
        T tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
