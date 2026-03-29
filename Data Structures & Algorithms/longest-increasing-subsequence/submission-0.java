class Solution {
    int[][] cache;
    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length][nums.length + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int currIdx, int lastIdx) {
        if (currIdx == nums.length) {
            return 0;
        }
        if (cache[currIdx][lastIdx + 1] != -1) {
            return cache[currIdx][lastIdx + 1];
        }

        int longest = dfs(nums, currIdx + 1, lastIdx);

        if (lastIdx == -1 || nums[currIdx] > nums[lastIdx]) {
            longest = Math.max(longest, dfs(nums, currIdx + 1, currIdx) + 1);
        }
        cache[currIdx][lastIdx + 1] = longest;
        return longest;
    }
}
