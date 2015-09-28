/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 For example:
 Given n = 13,
 Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */


/**
 * Solution:
 * 1.each time we calculate the number of ones in k's place
 * 2.add all of them
 */
public class Number_of_Digit_One {
    public int countDigitOne(int n){
        int count = 0;
        long m=0, r=0;
        for(long k=1;k<=n;k *=10){
            r = n/k;
            m = n%k;
            //we need consider the digit is larger than 2
            count += (r+8)/10 * k + (r%10==1? m+1 : 0);
        }
        return count;
    }
}
