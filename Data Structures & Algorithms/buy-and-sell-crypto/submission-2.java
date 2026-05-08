class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int max = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int gain = prices[right] - prices[left];
                max = Math.max(max, gain);
            } else {
                left = right;
            }
            right++;
        }
        return max;
    }
}
