import java.util.HashSet;
import java.util.Iterator;

/**
 *Given an array of integers, every element appears twice except for one.
 * Find that single one.
 */

//Solution1: use HashSet
public class Single_Number {
    public int singleNumber(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
}

//Solution2: use XOR, because XOR is commutative(交换性) and associative（结合性）
class Single_Number2 {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }
}