class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_sorted = sorted(nums)
        left, right = 0, len(nums) - 1
        for _ in range(len(nums)):
            curr = nums[left] + nums[right]
            if curr < target:
                left += 1
            elif curr > target:
                right -= 1
            else:
                return [left, right]