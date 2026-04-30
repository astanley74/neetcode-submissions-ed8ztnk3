class Solution {
    private int size;
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] board = new char[size][size];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }

        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board);
        return result;
    }

    private void backtrack(int row, Set<Integer> diags, Set<Integer> antiDiags, Set<Integer> cols, char[][] board) {
        if (row == size) {
            List<String> fullBoard = new ArrayList<>();
            for (char[] currRow : board) {
                fullBoard.add(new String(currRow));
            }
            result.add(fullBoard);
            return;
        }

        for (int col = 0; col < size; col++) {
            int currDiag = row - col, currAntiDiag = row + col;

            if (diags.contains(currDiag) || antiDiags.contains(currAntiDiag) || cols.contains(col)) {
                continue;
            }

            board[row][col] = 'Q';
            diags.add(currDiag);
            antiDiags.add(currAntiDiag);
            cols.add(col);
            backtrack(row + 1, diags, antiDiags, cols, board);
            board[row][col] = '.';
            diags.remove(currDiag);
            antiDiags.remove(currAntiDiag);
            cols.remove(col);
        }

    }
}
