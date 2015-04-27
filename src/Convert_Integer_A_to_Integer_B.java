/**
 * Determine the number of bits required to convert integer A to integer B

 Example
 Given n = 31, m = 14,return 2

 (31)10=(11111)2

 (14)10=(01110)2

 Tags Expand
 Cracking The Coding Interview Bit Manipulation Binary Representation
 */
public class Convert_Integer_A_to_Integer_B {
    public static int bitSwapRequired(int a, int b){
        if(a==b)return 0;
        //按位异或，get all different bits
        int bit = a^b;
        //record amount of difference
        int count =0;
        //Integer has 32 bits
        int num = 32;
        while(num>0){
            //按位与，we get the number of 1 with using bit&1 == 1
            count += bit & 1;
            bit = bit>>1;
            num--;
        }
        return count;
    }
}
