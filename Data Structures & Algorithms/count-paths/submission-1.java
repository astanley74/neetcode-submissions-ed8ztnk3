class Solution {
    int[][] cache;
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        for (int row = m - 1; row >= 0; row--) {
            int[] curr = new int[n];
            curr[n - 1] = 1;
            for (int col = n - 2; col >= 0; col--) {
                curr[col] = curr[col + 1] + prev[col];
            }
            prev = curr;
        }
        return prev[0];
    }
}
