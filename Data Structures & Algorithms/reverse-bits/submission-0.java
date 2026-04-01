class Solution {
    public int reverseBits(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                builder.append('1');
            } else {
                builder.append('0');
            }
        }
        String reversed = builder.reverse().toString();
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (reversed.charAt(i) == '1') {
                result |= (1 << i);
            }
        }
        return result;
    }
}
