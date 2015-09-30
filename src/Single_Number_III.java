import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by wangxinli on 9/29/15.
 */
public class Single_Number_III {
    //Solution1:bit Manipulation
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num: nums){
            diff^=num;
        }
        //two different number must be have one different bit,we get the highest bit:100,10,1 etc.
        diff = Integer.highestOneBit(diff);

        int[] result = {0,0};
        //divide into two groups
        for(int num: nums){
            //one of two number must be 0 when & to diff
            if((diff & num) == 0){
                result[0] ^= num;
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Single_Number_III s = new Single_Number_III();
        int[] nums = {1,2,4,1,2,5};
        s.singleNumber(nums);

    }


    public int[] singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            if(set.add(num)){
                continue;
            }else{
                set.remove(num);
            }
        }
        int[] result = new int[2];
        int i = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            result[i] = (int)iterator.next();
            i++;
        }
        return result;
    }

}
