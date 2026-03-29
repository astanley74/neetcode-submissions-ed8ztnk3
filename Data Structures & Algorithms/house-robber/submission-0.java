class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] money = new int[nums.length + 1];
        money[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            int skip = money[i - 1];
            int take = money[i - 2] + nums[i - 1];
            money[i] = Math.max(skip, take);
        }
        return money[nums.length];
    }
}
