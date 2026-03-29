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
        int[] cache = new int[nums.length];
        cache[start] = nums[start];
        cache[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            cache[i] = Math.max(cache[i - 1], cache[i - 2] + nums[i]);
        }
        return cache[end];
    }
}
