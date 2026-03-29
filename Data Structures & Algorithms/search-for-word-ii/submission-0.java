class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                curr.children.putIfAbsent(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.word = word;
        }

        List<String> result = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtrack(board, result, row, col, root);
                }
            }
        }
        return result;
    }

    private void backtrack(char[][] board, List<String> result, int row, int col, TrieNode node) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'V') {
            return;
        }

        if (!node.children.containsKey(board[row][col])) {
            return;
        }
        char ch = board[row][col];
        TrieNode next = node.children.get(ch);

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[row][col] = 'V';

        backtrack(board, result, row + 1, col, next);
        backtrack(board, result, row - 1, col, next);
        backtrack(board, result, row, col + 1, next);
        backtrack(board, result, row, col - 1, next);

        board[row][col] = ch;
    }
}

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;
}
