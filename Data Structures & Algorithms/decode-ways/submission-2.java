class Solution {
    public int numDecodings(String s) {
        return dfs(0, s);
    }

    private int dfs(int index, String str) {
        if (index == str.length()) {
            return 1;
        }
        if (str.charAt(index) == '0') {
            return 0;
        }

        int result = dfs(index + 1, str);

        if (index < str.length() - 1) {
            if (str.charAt(index) == '1' || (str.charAt(index) == '2' && str.charAt(index) < '7')) {
                result += dfs(index + 2, str);
            }
        }
        return result;
    }
}
