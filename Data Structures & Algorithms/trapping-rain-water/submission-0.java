class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int result = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                result += Math.max(0, leftMax - height[left]);
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                result += Math.max(0, rightMax - height[right]);
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return result;
    }
}
