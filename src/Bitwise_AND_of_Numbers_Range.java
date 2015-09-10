/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.
 */

//此题是求从m到n所有数相与的位是多少
public class Bitwise_AND_of_Numbers_Range {
    /**
     *     8  4  2  1
        ---------------
        5 | 0  1  0  1
        6 | 0  1  1  0
        7 | 0  1  1  1

    Solution1: from n to m, every two element execute & operation
    */

    public int rangeBitwiseAnd(int m, int n) {
        while(n>m){
            n = n & (n-1);
        }
        return n;
    }

    /**
     * Solution2:
     * 1.Because the highest bit of m and n is same
     * 2.each time m and n move right 1 bit, until m = n
     * 3.at the same time, we need to record how many times we move
     * 4.move left the number times
     */
    public int rangeBitwiseAnd2(int m, int n) {
        int index = 0;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            index++;
        }
        return (m<<index);
    }
}
