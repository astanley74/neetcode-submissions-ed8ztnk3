class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return dfs(grid, row, col, visited);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 1;
        }
        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        return dfs(grid, row + 1, col, visited) + dfs(grid, row - 1, col, visited) + dfs(grid, row, col + 1, visited) + dfs(grid, row, col - 1, visited);
    }
}