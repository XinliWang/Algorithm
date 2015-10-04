/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 return 2 because 13 = 4 + 9.
 */
public class Perfect_Squares {
    //recursive
    public int numSquares(int n) {
        if(n==0)return 0;
        int sq = (int)Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for(int i=sq;i>sq/2 && i>0;i--){
            int m = i*i;
            min = Math.min(min,n/m + numSquares(n%m));
        }
        return min;
    }
}
