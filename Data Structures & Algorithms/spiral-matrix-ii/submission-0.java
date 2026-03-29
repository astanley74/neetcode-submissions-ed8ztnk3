class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, current = 1;

        while (left <= right) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = current;
                current += 1;
            }
            top += 1;
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = current;
                current += 1;
            }
            right -= 1;
            for (int col = right; col >= left; col--) {
                matrix[bottom][col] = current;
                current += 1;
            }
            bottom -= 1;
            for (int row = bottom; row >= top; row--) {
                matrix[row][left] = current;
                current += 1;
            }
            left += 1;
        }
        return matrix;
    }
}