package career.Amazon;

import java.util.*;

/**
 * 给一个CPoint数组，求离原点最近的k个点) 昨天还一直担心地里说的 PriorityQueue compile 的问题，
 * 结果还是让给碰到，苦难接踵而至真的是世间真理。不过楼主 compile 并没有问题，5/5 pass，
 * 给一个CPoint数组，求离原点最近的k个点。
 class CPoint{
    double x;
    double y;
 }
 我就按照离原点距离 x*x+y*y 排了个序，取前k个.
 */
class CPoint{
    double x;
    double y;
    public CPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class ClosestKList {
    public List<CPoint> findKClosest(CPoint[] p, int k) {
        PriorityQueue<CPoint> pq = new PriorityQueue<>(10,new Comparator<CPoint>() {
            @Override
            public int compare(CPoint o1, CPoint o2) {
                double result = (o2.x*o2.x+o2.y*o2.y) - (o1.x*o1.x+o1.y*o1.y);
                if(result>0)return 1;
                else if(result==0)return 0;
                else return -1;
            }
        });
        for (int i = 0; i < p.length; i++) {
            if (i < k)
                pq.offer(p[i]);
            else {
                CPoint temp = pq.peek();
                if ((p[i].x * p[i].x + p[i].y * p[i].y) - (temp.x * temp.x + temp.y * temp.y) < 0) {
                    pq.poll();
                    pq.offer(p[i]);
                }
            }
        }
        List<CPoint> x = new ArrayList<>();
        while (!pq.isEmpty())
            x.add(pq.poll());
        return x;
    }
}
