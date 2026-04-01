class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num != 0) {
                sum += 1;
                num &= num - 1;
            }
            result[i] = sum;
        }
        return result;
    }
}
