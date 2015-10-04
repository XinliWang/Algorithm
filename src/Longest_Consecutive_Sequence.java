import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class Longest_Consecutive_Sequence {
    /**
     * Solution1: Using HashSet
     * 1. save all element into array
     * 2. then make every element to the center,try to remove from left and right
     * 3. at the same time, we calculate the length and get the maximum
     */
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max=1;
        for(int num:nums){
            //make sure this element is not visited
            if(set.remove(num)){
                int sum=1;
                int center = num;
                while(set.remove(center-1))center--;
                sum += num - center;
                center = num;
                while(set.remove(center+1))center++;
                sum += center - num;
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    /**
     * Solution2:Using HashMap
     * 1.save the element into key and element+1 into value
     * 2.get this value of key, and using this value to get the next value
     * 3.if we can get it, continue executing, otherwise get the length;
     */
    public int longestConsecutive2(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,num+1);
        }
        int max=1;
        for(int num:nums){
            if(map.containsKey(num-1)){
                continue;
            }
            int sum=1;
            int temp = num;
            while(map.containsKey(++temp)){
                sum++;
            }
            max = Math.max(sum,max);
        }
        return max;
    }



}
