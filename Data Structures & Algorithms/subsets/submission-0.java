class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        findSubsets(0, subsets, currSet, nums);
        return subsets;
    }

    private void findSubsets(int index, List<List<Integer>> subsets, List<Integer> currSet, int[] nums) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(currSet));
            return;
        }
        currSet.add(nums[index]);
        findSubsets(index + 1, subsets, currSet, nums);

        currSet.remove(currSet.size() - 1);
        findSubsets(index + 1, subsets, currSet, nums);
    }
}
