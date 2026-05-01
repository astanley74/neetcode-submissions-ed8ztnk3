class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                heap.offer(freq[i]);
            }
        }
        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        while (!heap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!heap.isEmpty()) {
                int count = heap.poll();
                if (count > 1) {
                    queue.add(new int[]{count - 1, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                heap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
