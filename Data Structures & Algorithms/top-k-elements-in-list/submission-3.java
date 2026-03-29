class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            while (heap.size() > k) {
                heap.poll();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            ans[i++] = heap.poll()[1];
        }
        return ans;
    }
}
