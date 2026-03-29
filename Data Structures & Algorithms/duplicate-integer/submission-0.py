class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        hashset = set(nums)
        return len(nums) != len(hashset)
