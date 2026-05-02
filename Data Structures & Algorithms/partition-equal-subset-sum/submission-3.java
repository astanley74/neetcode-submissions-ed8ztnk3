class Solution {
    private Boolean cache[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        cache = new Boolean[nums.length][sum / 2 + 1];

        return dfs(nums, 0, sum / 2);
    }

    private boolean dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0;
        }
        if (target < 0) {
            return false;
        }

        if (cache[index][target] != null) {
            return cache[index][target];
        }

        return cache[index][target] = dfs(nums, index + 1, target) || dfs(nums, index + 1, target - nums[index]);
    }
}
