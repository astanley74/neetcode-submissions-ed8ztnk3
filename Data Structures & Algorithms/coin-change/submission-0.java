class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = dfs(coins, amount);
        if (result >= 10000000) {
            return -1;
        }
        return result;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int result = 10000000;

        for (int coin : coins) {
            if (amount - coin >= 0) {
                result = Math.min(result, 1 + dfs(coins, amount - coin));
            }
        }
        return result;
    }
}
