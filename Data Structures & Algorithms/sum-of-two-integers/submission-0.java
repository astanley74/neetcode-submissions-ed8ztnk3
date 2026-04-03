class Solution {
    public int getSum(int a, int b) {
        int sum = 0, carry = 0;

        for (int i = 0; i < 32; i++) {
            int bit1 = (a >> i) & 1;
            int bit2 = (b >> i) & 1;
            int curr = bit1 ^ bit2 ^ carry;
            if (bit1 + bit2 + carry >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            if (curr != 0) {
                sum |= (1 << i);
            }
        }
        return sum;
    }
}
