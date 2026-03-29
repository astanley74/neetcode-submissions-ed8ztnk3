class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        int result = dfs(coins, amount, cache);
        if (result >= 10000000) {
            return -1;
        }
        return result;
    }

    private int dfs(int[] coins, int amount, Map<Integer, Integer> cache) {
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }
        int result = 10000000;

        for (int coin : coins) {
            if (amount - coin >= 0) {
                result = Math.min(result, 1 + dfs(coins, amount - coin, cache));
            }
        }
        cache.put(amount, result);
        return result;
    }
}
