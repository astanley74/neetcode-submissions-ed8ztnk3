class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> winCount = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }

        int current = 0, need = tCount.size(), left = 0, winLength = Integer.MAX_VALUE;
        int[] window = new int[]{-1, -1};

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            winCount.put(rChar, winCount.getOrDefault(rChar, 0) + 1);

            if (tCount.containsKey(rChar) && tCount.get(rChar) == winCount.get(rChar)) {
                current += 1;
            }

            while (current == need) {
                if ((right - left + 1) < winLength) {
                    winLength = right - left + 1;
                    window[0] = left;
                    window[1] = right;
                }
                char lChar = s.charAt(left);

                winCount.put(lChar, winCount.get(lChar) - 1);

                if (tCount.containsKey(lChar) && tCount.get(lChar) > winCount.get(lChar)) {
                    current -= 1;
                }
                left += 1;
            }
        }
        if (winLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(window[0], window[1] + 1);
        }
    }
}
