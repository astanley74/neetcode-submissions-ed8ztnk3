/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval int1 = intervals.get(i - 1);
            Interval int2 = intervals.get(i);

            if (int1.end > int2.start) {
                return false;
            }
        }
        return true;
    }
}
