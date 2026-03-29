class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prod, zero_count = 1, 0

        for num in nums:
            if num == 0:
                zero_count += 1
                if zero_count > 1:
                    return [0] * len(nums)
            else:
                prod *= num
        
        res = [0] * len(nums)

        for i, num in enumerate(nums):
            if zero_count < 1:
                res[i] = prod // nums[i]
            else:
                if num == 0:
                    res[i] = prod
                else:
                    res[i] = 0
        return res