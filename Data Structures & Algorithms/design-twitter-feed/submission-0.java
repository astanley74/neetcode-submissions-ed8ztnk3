class Twitter {
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;
    private int time;

    public Twitter() {
        this.time = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        this.tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{this.time--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        this.followMap.computeIfAbsent(userId, key -> new HashSet<>()).add(userId);
        for (int followeeId : this.followMap.get(userId)) {
            if (this.tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = this.tweetMap.get(followeeId);
                int[] tweet = tweets.get(tweets.size() - 1);
                heap.offer(new int[]{tweet[0], tweet[1], followeeId, tweets.size() - 1});
            }
        }

        while (!heap.isEmpty() && result.size() < 10) {
            int[] curr = heap.poll();
            result.add(curr[1]);
            int index = curr[3];
            if (index > 0) {
                int[] tweet = this.tweetMap.get(curr[2]).get(index - 1);
                heap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        this.followMap.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        this.followMap.computeIfPresent(followerId, (key, val) -> {
            val.remove(followeeId);
            return val;
        });
    }
}
