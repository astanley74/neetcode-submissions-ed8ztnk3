class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        left, right = 0, len(nums) - 1
        while left < right:
            actual = nums[left] + nums[right]
            if actual == target:
                return [left, right]
            if actual < target:
                left += 1
            else:
                right -= 1
        return []
            