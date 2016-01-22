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
        for(int num:nums){
            if(!set.add(num)){
                set.remove(num);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }


//Solution2: use XOR, because XOR is commutative(交换性) and associative（结合性）
    public int singleNumber2(int[] nums) {
        int result=0;
        for(int num:nums){
            result ^= num;
        }
        return result;
    }
}
