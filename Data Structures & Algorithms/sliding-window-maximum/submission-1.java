class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            int currMax = nums[i];
            for (int j = i; j < i + k; j++) {
                currMax = Math.max(currMax, nums[j]);
            }
            result[i] = currMax;
        }
        return result;
    }
}
