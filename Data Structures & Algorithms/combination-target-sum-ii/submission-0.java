class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(int index, List<List<Integer>> result, List<Integer> currCombo, int[] candidates, int target, int currSum) {
        if (currSum == target) {
            result.add(new ArrayList<>(currCombo));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (currSum + candidates[i] > target) {
                return;
            }
            currCombo.add(candidates[i]);
            backtrack(i + 1, result, currCombo, candidates, target, currSum + candidates[i]);
            currCombo.remove(currCombo.size() - 1);
        }
    }
}
