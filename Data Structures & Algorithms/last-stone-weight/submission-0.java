class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            heap.offer(stone);
        }

        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();

            if (b < a) {
                heap.offer(a - b);
            }
        }

        if (heap.isEmpty()) {
            return 0;
        }

        return heap.poll();
    }
}
