class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), result, 0, 0, n);
        return result;
    }

    private void backtrack(StringBuilder str, List<String> result, int open, int close, int n) {
        if (str.length() == 2 * n) {
            result.add(str.toString());
            return;
        }

        if (open < n) {
            str.append('(');
            backtrack(str, result, open + 1, close, n);
            str.deleteCharAt(str.length() - 1);
        }

        if (close < open) {
            str.append(')');
            backtrack(str, result, open, close + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
