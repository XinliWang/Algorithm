import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

/**
 * 1. create a new list, each time to compare or add Interval
 * 2. if i.end is less than newInterval.start , then add i
 * 3. if i.start is greater than newInterval.end , then add newInterval. Then change newInterval to null
 *     so that we can only add i in last steps.
 * 4. if they have overlapping intervals, then change newInterval's start and end value to the min and max.
 *    Then go on the next loop.
 * 5. At last, we need to consider if newInterval is null, if it's not,it means newInterval is still not in the new list.
 *    We need to add it.
 */
public class Insert_Interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        for (Interval i: intervals){
            if (newInterval==null || i.end < newInterval.start){
                list.add(i);
            }else if(i.start>newInterval.end){
                list.add(newInterval);
                list.add(i);
                newInterval = null;
            }else{
                newInterval.start = Math.min(newInterval.start,i.start);
                newInterval.end = Math.max(newInterval.end,i.end);
            }
        }
        if (newInterval!=null){
            list.add(newInterval);
        }
        return list;
    }
}
