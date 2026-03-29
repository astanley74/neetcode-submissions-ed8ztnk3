class Solution {
    private Map<Character, String> phone = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) {
            backtrack("", 0, digits, result);
        }
        return result;
    }

    private void backtrack(String path, int index, String digits, List<String> result) {
        if (index == digits.length()) {
            result.add(path);
            return;
        }

        for (char ch : phone.get(digits.charAt(index)).toCharArray()) {
            backtrack(path + ch, index + 1, digits, result);
        }
    }
}
