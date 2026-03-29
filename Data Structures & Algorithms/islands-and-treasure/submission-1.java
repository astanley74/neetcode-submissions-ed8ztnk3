class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private int ROWS, COLS;

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
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

    private int bfs(int[][] grid, int r, int c) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{r, c});
        boolean[][] visit = new boolean[ROWS][COLS];
        visit[r][c] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1];

                if (grid[row][col] == 0) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && 
                    !visit[newRow][newCol] && grid[newRow][newCol] != -1) {
                        visit[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
            steps++;
        }
        return INF;
    }
}
