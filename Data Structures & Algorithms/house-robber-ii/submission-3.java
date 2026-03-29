class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robHelper(0, nums.length - 2, nums), robHelper(1, nums.length - 1, nums));
    }

    private int robHelper(int start, int end, int[] nums) {
        if (start == end) {
            return nums[start];
        }
        int twoBack = nums[start];
        int oneBack = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int curr = Math.max(oneBack, twoBack + nums[i]);
            twoBack = oneBack;
            oneBack = curr;
        }
        return oneBack;
    }
}
