/**
 * Write an algorithm which computes the number of trailing zeros
 * in n factorial.

 Example
 11! = 39916800, so the out should be 2

 Challenge
 O(log N) time

 Tags Expand
 Mathematics
 */
public class Trailing_Zeros {
    public int trailingZero(int n){
        int result = 0;
        while(n>0){
            result += n/5;
            n= n/5;
        }
        return result;
    }
}
