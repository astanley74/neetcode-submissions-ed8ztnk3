class Solution {
    int[] cache;
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int ans = 1;
        int next = 1;
        for (int i = 2; i <= n; i++) {
            int curr = ans + next;
            next = ans;
            ans = curr;
        }
        return ans;
    }
}
