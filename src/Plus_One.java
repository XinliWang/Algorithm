/**
 * Given a non-negative number represented as an array of digits,
 * plus one to the number.
   The digits are stored such that the most significant digit is at the head of the list.
 */

//数组是一个数，加1是加到最后一位，如果有进位则向前进一位，每一位必须是个位数
public class Plus_One {
    public int[] plusOne(int[] digits){
        int size = digits.length;
        for (int i=size-1;i>=0;i--){
            if(digits[i]+1==10){
                digits[i] = 0;
                if(i==0){
                    int[] array = new int[size+1];
                    array[0] = 1;
                    for(int j=1;j<size;j++){
                        array[j] = 0;
                    }
                    return array;
                }
            }else{
                digits[i] = digits[i]+1;
                return digits;
            }
        }
        return digits;
    }
}
