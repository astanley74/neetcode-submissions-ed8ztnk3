class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = {}
        buckets = [[] for i in range(len(nums) + 1)]
        for num in nums:
            counts[num] = counts.get(num, 0) + 1
        
        for num, freq in counts.items():
            buckets[freq].append(num)
        
        ans = []

        for i in range(len(buckets) - 1, 0, -1):
            for num in buckets[i]:
                ans.append(num)
                if len(ans) == k:
                    return ans