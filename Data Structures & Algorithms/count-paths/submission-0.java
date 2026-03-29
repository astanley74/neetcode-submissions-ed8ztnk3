class Solution {
    int[][] cache;
    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, m, n);
    }

    private int dfs(int row, int col, int rows, int cols) {
        if (row == rows - 1 || col == cols - 1) {
            return 1;
        }
        if (row >= rows || col >= cols) {
            return 0;
        }

        if (cache[row][col] != -1) {
            return cache[row][col];
        }

        cache[row][col] = dfs(row, col + 1, rows, cols) + dfs(row + 1, col, rows, cols);
        return cache[row][col];
    }
}
