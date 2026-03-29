class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, String word, int currLength) {
        if (currLength == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(currLength) || board[row][col] == 'V') {
            return false;
        }

        board[row][col] = 'V';

        boolean ans = backtrack(board, row + 1, col, word, currLength + 1) ||
                        backtrack(board, row - 1, col, word, currLength + 1) ||
                        backtrack(board, row, col + 1, word, currLength + 1) ||
                        backtrack(board, row, col - 1, word, currLength + 1);
        board[row][col] = word.charAt(currLength);
        return ans;

    }
}
