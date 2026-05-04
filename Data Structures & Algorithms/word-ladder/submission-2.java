class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> neighbors = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                neighbors.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int ans = 1;

        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return ans;
                }
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String neighborWord : neighbors.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(neighborWord)) {
                            visited.add(neighborWord);
                            queue.offer(neighborWord);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}
