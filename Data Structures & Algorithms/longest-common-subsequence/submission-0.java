class Solution {
    int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
        cache = new int[text1.length()][text2.length()];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int index1, int index2) {
        if (index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }

        if (cache[index1][index2] != -1) {
            return cache[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            cache[index1][index2] = dfs(text1, text2, index1 + 1, index2 + 1) + 1;
        } else {
            cache[index1][index2] = Math.max(dfs(text1, text2, index1 + 1, index2), dfs(text1, text2, index1, index2 + 1));
        }

        return cache[index1][index2];
    }
}
