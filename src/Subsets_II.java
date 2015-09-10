import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());
        int size = nums.length;
        if(size==0)return lists;
        Arrays.sort(nums);
        for(int i=0;i<size;i++){
            List<List<Integer>> templists = new ArrayList<>();
            templists.addAll(lists);
            for(List<Integer> l : lists){
                List<Integer> newlist = new ArrayList<>(l);
                newlist.add(nums[i]);
                if(!templists.contains(newlist)){
                    templists.add(newlist);
                }
            }
            lists = templists;
        }
        return lists;
    }

}
