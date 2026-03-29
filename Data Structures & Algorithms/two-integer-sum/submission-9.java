class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int curr = nums[left] + nums[right];
            if (curr == target) {
                return new int[]{left, right};
            }
            else if (curr > target) {
                right -= 1;
            } else {
                left +=1;
            }
        }
        return new int[]{0,0};
    }
}
