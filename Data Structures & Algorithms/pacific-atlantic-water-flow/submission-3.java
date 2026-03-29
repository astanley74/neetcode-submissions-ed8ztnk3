class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < ROWS; row++) {
            dfs(heights, row, 0, pacific);
            dfs(heights, row, COLS - 1, atlantic);
        }

        for (int col = 0; col < COLS; col++) {
            dfs(heights, 0, col, pacific);
            dfs(heights, ROWS - 1, col, atlantic);
        }

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] ocean) {
        ocean[row][col] = true;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            if (nRow >= 0 && nCol >= 0 && nRow < heights.length && nCol < heights[0].length && !ocean[nRow][nCol]) {
                if (heights[row][col] <= heights[nRow][nCol]) {
                    dfs(heights, nRow, nCol, ocean);
                }
            }
        }
    }
}
