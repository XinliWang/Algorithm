/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 返回n！里面0的个数
 */



//n!=2^x * 3^y * 5^z , 所以只要统计5的个数
public class Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n){
        int result = 0;
        while(n!=0){
            result += n/5;
            n /= 5;
        }
        return result;
    }
}
