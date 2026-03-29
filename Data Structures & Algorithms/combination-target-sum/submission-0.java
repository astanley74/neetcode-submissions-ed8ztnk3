class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(0, combinations, new ArrayList<>(), nums, target, 0);
        return combinations;
    }

    private void backtrack(int index, List<List<Integer>> combinations, List<Integer> currCombo, int[] nums, int target, int currSum) {
        if (currSum == target) {
            combinations.add(new ArrayList<>(currCombo));
            return;
        }

        for (int newIndex = index; newIndex < nums.length; newIndex++) {
            if (currSum + nums[newIndex] > target) {
                return;
            }
            currCombo.add(nums[newIndex]);
            backtrack(newIndex, combinations, currCombo, nums, target, currSum + nums[newIndex]);
            currCombo.remove(currCombo.size() - 1);
        }
    }
}
