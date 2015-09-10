import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */

class Interval{
    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }
    Interval(int s,int e){
        start = s;
        end = e;
    }
}

//sort and merge, override sort().
public class Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals){
        if (intervals == null || intervals.size()<=1)return intervals;

        Collections.sort(intervals,new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> list = new ArrayList<>();
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for (int i=1;i<intervals.size();i++){
            Interval cur = intervals.get(i);
            if (cur.start > e){
                list.add(new Interval(s,e));
                s = cur.start;
                e = cur.end;
            }else{
                e = Math.max(e,cur.end);
            }
        }
        list.add(new Interval(s,e));
        return list;

    }
}



