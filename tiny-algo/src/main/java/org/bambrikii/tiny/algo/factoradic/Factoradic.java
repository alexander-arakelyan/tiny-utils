package org.bambrikii.tiny.algo.factoradic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://math.stackexchange.com/questions/1371995/how-to-find-the-next-higher-permutation-out-of-a-fixed-group-of-digits
 */
public class Factoradic {
    private Factoradic() {
    }

    private static char[] sort(char[] alphabet) {
        char[] sorted = new char[alphabet.length];
        System.arraycopy(alphabet, 0, sorted, 0, alphabet.length);
        Arrays.sort(sorted);
        return sorted;
    }

    public static int toDecimal(String factoradic) {
        char[] alpha = factoradic.toCharArray();
        var chars = index(sort(alpha));
        int len = factoradic.length();
        int decimal = 0;
        for (int i = 0; i < len; i++) {
            Character ch = alpha[i];
            int pos = chars.indexOf(ch);
            chars.remove(ch);
            int mul = len - i;
            decimal = decimal * mul + pos;
        }
        return decimal;
    }

    private static List<Character> index(char[] sorted) {
        var list = new ArrayList<Character>();
        for (int i = 0; i < sorted.length; i++) {
            list.add(sorted[i]);
        }
        return list;
    }

    public static String toFactoradic(String original, int decimal) {
        var alpha = original.toCharArray();
        var chars = index(sort(alpha));
        var i = 1;
        var n = decimal;
        var positions = new ArrayList<Integer>();
        while (n > 0) {
            var pos = n % i;
            positions.add(pos);
            n /= i;
            i++;
        }
        var sb = new StringBuilder();
        for (int j = positions.size() - 1; j >= 0; j--) {
            var ch = chars.get(positions.get(j));
            chars.remove(ch);
            sb.append(ch.charValue());
        }
        return sb.toString();
    }
}
