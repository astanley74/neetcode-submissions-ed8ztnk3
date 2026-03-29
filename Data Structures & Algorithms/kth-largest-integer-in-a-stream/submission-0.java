class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            this.minHeap.offer(num);
            if (this.minHeap.size() > k) {
                this.minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if (this.minHeap.size() > k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }
}
