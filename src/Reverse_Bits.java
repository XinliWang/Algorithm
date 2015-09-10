/**
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
public class Reverse_Bits {
    public int reverseBits(int n){
        int s = 0;
        int i = 0;
        while(i<32){
            //左移一位，该位为0，然后和n的最后一位取或，n的最后一位通过与1取与操作得到
            s = (s<<=1)|(n&1);
            //n向右移一位
            n>>>=1;
            //确保位数为32
            i++;
        }
        return s;
    }
}
