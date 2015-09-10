/**
 * Write a function that takes an unsigned integer and
 * returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary
 representation 00000000000000000000000000001011, so the function should return 3.
 */
//此处的n为unsigned integer，所以不能用n%2==1的方法统计1的个数，需要用位运算
public class Number_of_1_Bits {
    public int hammingWeight(int n){
        int count=0;
        while(n!=0){
            //& 按位与
            if((n & 1)==1){
                count++;
            }
            //向右移一位，无符号位为>>>,有符号位为>>
            n>>>=1;
        }
        return count;
    }
}
