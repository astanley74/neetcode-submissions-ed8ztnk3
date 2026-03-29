class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        boolean[][] cache = new boolean[s.length()][s.length()];

        for (int left = s.length() - 1; left >= 0; left--) {
            for (int right = left; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || cache[left + 1][right - 1])) {
                    cache[left][right] = true;
                    result += 1;
                }
            }
        }
        return result;
    }
}
