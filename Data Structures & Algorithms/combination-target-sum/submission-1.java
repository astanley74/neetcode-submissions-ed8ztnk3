class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList();
        backtrack(0, combinations, new ArrayList<>(), nums, target, 0);
        return combinations;
    }

    public void backtrack(int index, List<List<Integer>> combinations, List<Integer> combo, int[] nums, int target, int total) {
        if (total == target) {
            combinations.add(new ArrayList<>(combo));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (total + nums[i] > target) {
                return;
            }
            combo.add(nums[i]);
            backtrack(i, combinations, combo, nums, target, total + nums[i]);
            combo.remove(combo.size() - 1);
        }
    }
}
