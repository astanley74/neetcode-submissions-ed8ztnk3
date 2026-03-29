class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }

        int target = newInterval[0];
        int left = 0, right = intervals.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            ans.add(intervals[i]);
        }
        ans.add(newInterval);
        for (int i = 0; i < intervals.length; i++) {
            ans.add(intervals[i]);
        }

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : ans) {
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
