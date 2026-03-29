class Solution:
    def maxArea(self, heights: List[int]) -> int:
        ans = -1
        left, right = 0, len(heights) - 1
        while left < right:
            area = (right - left) * min(heights[left], heights[right])
            ans = max(ans, area)
            if heights[left] <= heights[right]:
                left += 1
            else:
                right -= 1
        return ans