class Solution {
    private int[] cache;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        int robFirst = dfs(0, nums.length - 2, nums);

        Arrays.fill(cache, -1);
        int skipFirst = dfs(1, nums.length - 1, nums);
        return Math.max(robFirst, skipFirst);
    }

    private int dfs(int index, int end, int[] nums) {
        if (index > end) {
            return 0;
        }
        if (this.cache[index] != -1) {
            return this.cache[index];
        }

        this.cache[index] = Math.max(dfs(index + 1, end, nums), dfs(index + 2, end, nums) + nums[index]);
        return this.cache[index];
    }
}
