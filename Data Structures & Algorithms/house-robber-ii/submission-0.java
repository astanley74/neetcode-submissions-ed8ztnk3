class Solution {
    private int[][] cache;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        cache = new int[nums.length][2];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return Math.max(dfs(0, 1, nums), dfs(1, 0, nums));
    }

    private int dfs(int index, int flag, int[] nums) {
        if (index >= nums.length || (flag == 1 && index == nums.length - 1)) {
            return 0;
        }
        if (this.cache[index][flag] != -1) {
            return this.cache[index][flag];
        }

        this.cache[index][flag] = Math.max(dfs(index + 1, flag, nums), dfs(index + 2, flag, nums) + nums[index]);
        return this.cache[index][flag];
    }
}
