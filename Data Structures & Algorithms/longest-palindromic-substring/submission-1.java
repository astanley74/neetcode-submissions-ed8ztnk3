class Solution {
    public String longestPalindrome(String s) {
        int resIndex = 0, resLength = 0;
        boolean[][] cache = new boolean[s.length()][s.length()];

        for (int left = s.length() - 1; left >= 0; left--) {
            for (int right = left; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <=2 || cache[left + 1][right - 1])) {
                    cache[left][right] = true;
                    if (resLength < (right - left + 1)) {
                        resIndex = left;
                        resLength = right - left + 1;
                    }
                }
            }
        }
        return s.substring(resIndex, resLength + resIndex);
    }
}
