import java.util.ArrayList;
import java.util.List;
/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code,
 print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */


/**
 * Solution1: According to WIKI about Gray code
 *
 Int    Grey Code    Binary
 0  　　  000        000
 1  　　  001        001
 2   　 　011        010
 3   　 　010        011
 4   　 　110        100
 5   　 　111        101
 6   　 　101        110
 7   　　 100        111

 */
public class Gray_Code {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<Math.pow(2,n);i++){
            list.add((i>>1)^i);
        }
        return list;
    }
    /**
     * Solution2:参考维基百科上关于格雷码的性质，有一条是说镜面排列的，
     * n位元的格雷码可以从n-1位元的格雷码以上下镜射后加上新位元的方式快速的得到
     * 参考：http://www.cnblogs.com/grandyang/p/4315649.html
     */
    public List<Integer> grayCode2(int n){
        List<Integer> newlist = new ArrayList<>();
        newlist.add(0);
        for(int i=0;i<n;i++){
            int highBit = 1<<i;
            int len = newlist.size();
            for(int j=len-1;j>=0;j--){
                newlist.add(highBit+newlist.get(j));
            }
        }
        return newlist;
    }
}
