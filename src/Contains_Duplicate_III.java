import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the difference between nums[i] and nums[j] is at most t
 * and the difference between i and j is at most k.
 */
public class Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            //keep the difference between i and j is at most k
            if(i>k){
                set.remove(Long.valueOf(nums[i-k-1]));
            }
            //nums[j] = lowerBound<= nums[i] <=upperBound
            long upperBound = (long)(nums[i]+t);
            long lowerBound = (long)(nums[i]-t);
            //low is the greatest number which is no more than upperBound in treeset
            Long low = set.floor(upperBound+1);
            //if({0},0,0),low is null. low should be greater than lowerBound
            if(low!=null && low>=lowerBound){
                return true;
            }
            set.add(Long.valueOf(nums[i]));
        }
        return false;
    }
}
