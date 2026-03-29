class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev = 0, take = 0;

        for (int num : nums) {
            int curr = Math.max(num + prev, take);
            prev = take;
            take = curr;
        }
        return take;
    }
}
