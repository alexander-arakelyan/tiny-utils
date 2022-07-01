package org.bambrikii.diff.tiny;

public class CompareStringsArr {
    private static final int MATCH = 1;
    private static final int DIFF = 0;

    public String compare(String strX, String strY) {
        int xLen = strX.length() + 1;
        int yLen = strY.length() + 1;
        int[][] curr = new int[xLen][yLen];
        char[][] chars = new char[xLen][yLen];
        fillX(xLen, curr);
        fillY(yLen, curr);
        fillMatrix(strX, strY, xLen, yLen, curr, chars);
        return extractString(curr, chars);
    }

    private void fillY(int yLen, int[][] curr) {
        for (int y = 0; y < yLen; y++) {
            curr[0][y] = 1;
        }
    }

    private void fillX(int xLen, int[][] curr) {
        for (int x = 0; x < xLen; x++) {
            curr[x][0] = 1;
        }
    }

    private void fillMatrix(String strX, String strY, int xLen, int yLen, int[][] curr, char[][] chars) {
        for (int x = 1; x < xLen; x++) {
            int posX = x - 1;
            for (int y = 1; y < yLen; y++) {
                int posY = y - 1;
                int match = match(strX, posX, strY, posY);
                int val = curr[x - 1][y - 1] + match;
                int left = curr[x - 1][y];
                int right = curr[x][y - 1];
                if (val < left) {
                    val = left;
                    match = 0;
                }
                if (val < right) {
                    val = right;
                    match = 0;
                }
                curr[x][y] = val;
                if (match == 1) {
                    chars[x][y] = strX.charAt(posX);
                }
            }
        }
    }

    private String extractString(int[][] curr, char[][] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < curr.length; i++) {
            for (int j = 1; j < curr[i].length; j++) {
                char ch = chars[i][j];
                if (ch != 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }


    private int match(String strX, int posX, String strY, int posY) {
        if (posX < 0 || posX >= strX.length()) {
            return DIFF;
        }
        if (posY < 0 || posY >= strY.length()) {
            return DIFF;
        }
        return strX.charAt(posX) == strY.charAt(posY) ? MATCH : DIFF;
    }
}
