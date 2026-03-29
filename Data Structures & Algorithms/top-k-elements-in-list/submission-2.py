class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dic = defaultdict(int)
        ans = []

        for num in nums:
            dic[num] += 1
        
        heap = []

        for num, count in dic.items():
            heapq.heappush(heap, (count, num))
            while len(heap) > k:
                heapq.heappop(heap)
        
        for i in range(len(heap)):
            ans.append(heapq.heappop(heap)[1])
        
        return ans