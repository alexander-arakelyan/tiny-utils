package org.bambrikii.tiny.diff;

import java.util.ArrayList;
import java.util.List;

public class CompareStringsBfs {
    public String compare(String left, String right) {
        compare(left, 0, right, 0, new ArrayList<>());
        if (res == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        res.forEach(ch -> sb.append(ch));
        return sb.toString();
    }

    private List<Character> res = null;

    private int compare(String left, int leftPos, String right, int rightPos, List<Character> result) {
        if (leftPos >= left.length()) {
            return result.size();
        }

        if (rightPos >= right.length()) {
            return result.size();
        }

        char leftChar = left.charAt(leftPos);
        char rightChar = right.charAt(rightPos);
        if (leftChar == rightChar) {
            result.add(leftChar);
            int len = compare(left, leftPos + 1, right, rightPos + 1, result);
            tryConclude(result, len);
            result.remove(result.size() - 1);
            return len;
        }
        int lenLeft = compare(left, leftPos + 1, right, rightPos, result);
        tryConclude(result, lenLeft);
        int lenRight = compare(left, leftPos, right, rightPos + 1, result);
        tryConclude(result, lenRight);
        if (lenLeft > lenRight) {
            return lenLeft;
        }
        return lenRight;
    }

    private void tryConclude(List<Character> result, int len) {
        if (res == null || len > res.size()) {
            res = new ArrayList<>(result);
        }
    }
}
