class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        uniques = set()

        for num in nums:
            if num in uniques:
                return True
            uniques.add(num)
        return False