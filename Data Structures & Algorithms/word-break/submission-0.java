class Solution {
    HashMap<Integer, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String str, List<String> dic, int index) {
        if (this.cache.containsKey(index)) {
            return this.cache.get(index);
        }
        if (index == str.length()) {
            return true;
        }

        for (String word : dic) {
            if (index + word.length() <= str.length() && str.substring(index, index + word.length()).equals(word)) {
                if (dfs(str, dic, index + word.length())) {
                    this.cache.put(index, true);
                    return true;
                }
            }
        }
        this.cache.put(index, false);
        return false;
    }
}
