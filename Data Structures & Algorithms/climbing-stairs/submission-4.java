class Solution {
    int[] cache;
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}
