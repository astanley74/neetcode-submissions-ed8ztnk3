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
        int[] window = new int[]{-1, -1};
        int current = 0, need = tCount.size(), left = 0, length = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            winCount.put(ch, winCount.getOrDefault(ch, 0) + 1);

            if (tCount.containsKey(ch) && winCount.get(ch).equals(tCount.get(ch))) {
                current += 1;
            }

            while (current == need) {
                if ((right - left + 1) < length) {
                    length = right - left + 1;
                    window[0] = left;
                    window[1] = right;
                }
                char lChar = s.charAt(left);
                winCount.put(lChar, winCount.get(lChar) - 1);
                if (tCount.containsKey(lChar) && winCount.get(lChar) < tCount.get(lChar)) {
                    current--;
                }
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(window[0], window[1] + 1);
    }
}
