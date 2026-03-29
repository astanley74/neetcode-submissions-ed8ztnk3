class Solution {
    public int numDecodings(String s) {
        int oneAhead = 1;
        int twoAhead = 0;

        for (int index = s.length() - 1; index >= 0; index--) {
            int current;
            if (s.charAt(index) == '0') {
                current = 0;
            } else {
                current = oneAhead;
                if (index + 1 < s.length() && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
                    current += twoAhead;
                }
            }
            twoAhead = oneAhead;
            oneAhead = current;
        }

        return oneAhead;
    }
}
