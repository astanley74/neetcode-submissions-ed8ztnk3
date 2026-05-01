class Solution {
    public int leastInterval(char[] tasks, int n) {
        //count frequency of each individual task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                queue.offer(freq[i]);
            }
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int count = n + 1;
            List<Integer> remain = new ArrayList();
            int numTasks = 0;

            while (count-- > 0 && !queue.isEmpty()) {
                int remaining = queue.poll();
                if (remaining > 1) {
                    remain.add(remaining - 1);
                }
                numTasks++;
            }

            for (int num : remain) {
                queue.offer(num);
            }
            time += queue.isEmpty() ? numTasks : n + 1;
        }
        return time;
    }
}
