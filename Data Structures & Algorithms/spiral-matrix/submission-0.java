class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        dfs(matrix, rows, cols, 0, -1, 0, 1, result);
        return result;
    }

    private void dfs(int[][] matrix, int rows, int cols, int row, int col, int rd, int cd, List<Integer> result) {
        if (rows == 0 || cols == 0) {
            return;
        }

        for (int i = 0; i < cols; i++) {
            row += rd;
            col += cd;
            result.add(matrix[row][col]);
        }
        dfs(matrix, cols, rows - 1, row, col, cd, -rd, result);
    }
}
