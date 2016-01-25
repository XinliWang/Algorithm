import java.util.HashSet;
import java.util.Iterator;

/**
 * Given an array of numbers nums,
 * in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity.
 Could you implement it using only constant space complexity?

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
