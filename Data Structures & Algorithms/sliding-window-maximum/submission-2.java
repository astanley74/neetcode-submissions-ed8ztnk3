class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0, right = 0;

        while (right < nums.length) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
                deque.removeLast();
            }
            deque.addLast(right);

            if (left > deque.getFirst()) {
                deque.removeFirst();
            }

            if (right + 1 >= k) {
                result[left] = nums[deque.getFirst()];
                left++;
            }
            right++;
        }
        return result;
    }
}
