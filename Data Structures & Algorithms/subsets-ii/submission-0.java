class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(0, subsets, new ArrayList<>(), nums);
        return subsets;
    }

    public void backtrack(int index, List<List<Integer>> subsets, List<Integer> currSet, int[] nums) {
        subsets.add(new ArrayList<>(currSet));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            currSet.add(nums[i]);
            backtrack(i + 1, subsets, currSet, nums);
            currSet.remove(currSet.size() - 1);
        }
    }
}
