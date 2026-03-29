class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            int[] charCount = new int[26];
            List<String> strings = new ArrayList<>();
            for (char ch : str.toCharArray()) {
                charCount[ch - 'a'] += 1;
            }
            String key = Arrays.toString(charCount);
            if (groups.get(key) != null) {
                groups.get(key).add(str);
            } else {
                groups.put(key, strings);
                groups.get(key).add(str);
            }
        }

        return new ArrayList<>(groups.values());
    }
}
