class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (totalTime(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int totalTime(int[] piles, int rate) {
        int total = 0;

        for (int i = 0; i < piles.length; i++) {
            total += Math.ceil((double) piles[i] / rate);
        }

        return total;
    }

    
}
