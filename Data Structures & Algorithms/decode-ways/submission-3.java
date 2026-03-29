class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfs(0, s, cache);
    }

    private int dfs(int index, String str, int[] cache) {
        if (index == str.length()) {
            return 1;
        }
        if (cache[index] != -1) {
            return cache[index];
        }
        if (str.charAt(index) == '0') {
            return 0;
        }

        int result = dfs(index + 1, str, cache);

        if (index < str.length() - 1) {
            if (str.charAt(index) == '1' || (str.charAt(index) == '2' && str.charAt(index + 1) < '7')) {
                result += dfs(index + 2, str, cache);
            }
        }
        cache[index] = result;
        return result;
    }
}
