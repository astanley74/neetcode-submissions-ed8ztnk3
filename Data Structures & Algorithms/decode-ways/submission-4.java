class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length() + 1];
        cache[s.length()] = 1;

        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) == '0') {
                cache[index] = 0;
            } else {
                cache[index] = cache[index + 1];
                if (index + 1 < s.length() && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
                    cache[index] += cache[index + 2];
                }
            }
        }

        return cache[0];
    }
}
