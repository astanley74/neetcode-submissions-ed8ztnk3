class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    public int dfs(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        if (cache[index] != -1) {
            return cache[index];
        }
        return cache[index] = cost[index] + Math.min(dfs(cost, index + 1), dfs(cost, index + 2));
    }
}
