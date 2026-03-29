class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] atlantic = new boolean[ROWS][COLS];
        boolean[][] pacific = new boolean[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {
            dfs(row, 0, pacific, heights);
            dfs(row, COLS - 1, atlantic, heights);
        }

        for (int col = 0; col < COLS; col++) {
            dfs(0, col, pacific, heights);
            dfs(ROWS - 1, col, atlantic, heights);
        }
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++)  {
                if (pacific[row][col] && atlantic[row][col]) {
                    ans.add(Arrays.asList(row, col));
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int col, boolean[][] ocean, int[][] heights) {
        ocean[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length &&
            !ocean[newRow][newCol] && heights[row][col] <= heights[newRow][newCol]) {
                dfs(newRow, newCol, ocean, heights);
            }
        }
    }
}
