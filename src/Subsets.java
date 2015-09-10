import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */

public class Subsets {
    /**
     * 1. create a empty list and add into a list
     * 2. each time use a temp list to add new lists,then  assign the value to the old list
     * 3. from first element to the last element, if every sublist doesn't have, then add it
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());
        int size = nums.length;
        if(size==0)return lists;
        Arrays.sort(nums);
        for (int i=0;i < size; i++){
            List<List<Integer>> templists = new ArrayList<>();
            templists.addAll(lists);
            for(List<Integer> l : lists){
                List<Integer> newlist = new ArrayList<>(l);
                if(!newlist.contains(nums[i])){
                    newlist.add(nums[i]);
                    templists.add(newlist);
                }
            }
            lists = templists;
        }
        return lists;
    }
}
