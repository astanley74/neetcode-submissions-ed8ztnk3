class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                queue.offer(freq[i]);
            }
        }
        int total = 0;

        while (!queue.isEmpty()) {
            int numTasks = 0;
            int cycleCount = n + 1;
            List<Integer> remaining = new ArrayList<>();

            while (cycleCount-- > 0 && !queue.isEmpty()) {
                int freqRem = queue.poll();
                if (freqRem > 1) {
                    remaining.add(freqRem - 1);
                }
                numTasks++;
            }
            for (int num : remaining) {
                queue.offer(num);
            }
            total += queue.isEmpty() ? numTasks : n + 1;
        }

        return total;
    }
}
