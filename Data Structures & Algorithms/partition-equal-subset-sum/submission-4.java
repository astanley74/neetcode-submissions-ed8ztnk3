class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] cache = new boolean[nums.length + 1][sum / 2 + 1];

        for (int i = 0; i <= nums.length; i++) {
            cache[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum / 
            2; j++) {
                if (nums[i - 1] <= j) {
                    cache[i][j] = cache[i - 1][j] || cache[i - 1][j - nums[i - 1]];
                } else {
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }
        return cache[nums.length][sum / 2];
    }
}
