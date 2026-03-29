class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
                left += 1;
            } else {
                right -= 1;
            }
        }
        return maxArea;
    }
}
