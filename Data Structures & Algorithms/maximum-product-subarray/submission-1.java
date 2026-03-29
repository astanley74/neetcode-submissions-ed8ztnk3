class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = 1, currMin = 1;

        for (int num : nums) {
            int temp = currMax * num;
            currMax = Math.max(Math.max(currMax * num, currMin * num), num);
            currMin = Math.min(Math.min(temp, currMin * num), num);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
