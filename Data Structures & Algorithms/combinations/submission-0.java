class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(1, combinations, new ArrayList<>(), k, n);
        return combinations;
    }

    private void backtrack(int index, List<List<Integer>> combinations, List<Integer> currCombo, int k, int n) {
        if (currCombo.size() == k) {
            combinations.add(new ArrayList<>(currCombo));
            return;
        }

        for (int i = index; i <= n; i++) {
            currCombo.add(i);
            backtrack(i + 1, combinations, currCombo, k, n);
            currCombo.remove(currCombo.size() - 1);
        }
    }
}