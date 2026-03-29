class Solution {

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        if (queue.size() == 0) {
            return;
        }

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0], col = node[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.add(new int[]{r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
