class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        findSubsets(0, subsets, currSet, nums);
        return subsets;
    }

    public void findSubsets(int index, List<List<Integer>> subsets, List<Integer> currSet, int[] nums) {
        if (index > nums.length) {
            return;
        }
        subsets.add(new ArrayList<>(currSet));

        for (int i = index; i < nums.length; i++) {
            currSet.add(nums[i]);
            findSubsets(i + 1, subsets, currSet, nums);
            currSet.remove(currSet.size() - 1);
        }
    }
}
