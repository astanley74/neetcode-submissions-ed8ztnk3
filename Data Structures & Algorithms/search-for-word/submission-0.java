class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null) {
            return false;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(row, col, board, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word, int currLength) {
        if (currLength == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(currLength)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = 'V';

        boolean valid = dfs(row + 1, col, board, word, currLength + 1) || dfs(row - 1, col, board, word, currLength + 1) || dfs(row, col + 1, board, word, currLength + 1) || dfs(row, col - 1, board, word, currLength + 1);

        board[row][col] = temp;

        return valid;
    }
}
