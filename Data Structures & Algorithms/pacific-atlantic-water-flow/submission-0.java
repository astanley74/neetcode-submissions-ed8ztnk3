class Solution {
    int ROWS, COLS;
    boolean pacific, atlantic;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                pacific = false;
                atlantic = false;
                dfs(heights, row, col, Integer.MAX_VALUE);
                if (pacific && atlantic) {
                    ans.add(Arrays.asList(row, col));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int row, int col, int prevVal) {
        if (row < 0 || col < 0) {
            pacific = true;
            return;
        }
        if (row >= ROWS || col >= COLS) {
            atlantic = true;
            return;
        }
        if (heights[row][col] > prevVal) {
            return;
        }
        int temp = heights[row][col];
        heights[row][col] = Integer.MAX_VALUE;
        for (int[] dir : directions) {
            dfs(heights, row + dir[0], col + dir[1], temp);
            if (pacific && atlantic) {
                break;
            }
        }
        heights[row][col] = temp;
    }
}
