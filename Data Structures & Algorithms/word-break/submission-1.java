class Solution {
    HashMap<Integer, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] cache = new boolean[s.length() + 1];
        cache[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    cache[i] = cache[i + word.length()];
                }
                if (cache[i]) {
                    break;
                }
            }
        }
        return cache[0];
    }
}
