class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int row = 0; row < ROWS; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }
            if (board[row][COLS - 1] == 'O') {
                dfs(board, row, COLS - 1);
            }
        }

        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }
            if (board[ROWS - 1][col] == 'O') {
                dfs(board, ROWS - 1, col);
            }
        }

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                if (board[row][col] == 'S') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        board[row][col] = 'S';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        if (row > 0 && col > 0 && row < board.length && col < board[0].length && board[row][col] == 'O') {
            for (int[] dir : directions) {
                dfs(board, row + dir[0], col + dir[1]);
            }
        }
    }
}
