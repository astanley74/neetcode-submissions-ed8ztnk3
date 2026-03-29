class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        while (left <= right) {
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top += 1;
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right -= 1;
            if (!(left <= right && top <= bottom)) {
                break;
            }
            for (int col = right; col >= left; col--) {
                result.add(matrix[bottom][col]);
            }
            bottom -= 1;
            for (int row = bottom; row >= top; row--) {
                result.add(matrix[row][left]);
            }
            left += 1;
        }
        return result;
    }
}
