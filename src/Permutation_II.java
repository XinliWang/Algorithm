import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].

 Hide Tags: Backtracking

 */
public class Permutation_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(lists, list, nums, isVisited);
        return lists;
    }
    //recursive
    private void helper(List<List<Integer>> lists,List<Integer> list,int[] nums,boolean[] isVisited){
        if(list.size()==nums.length ){
            if(!lists.contains(list)){
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        int lastNumber = nums[0]-1;
        for (int i=0;i<nums.length;i++){
            //if this element has visited or this element is equal to the previous element, we need to skip
            if(isVisited[i] || nums[i]==lastNumber)continue;
            isVisited[i]=true;
            list.add(nums[i]);
            helper(lists,list,nums,isVisited);
            //backtracking
            list.remove(list.size()-1);
            isVisited[i] = false;
        }

    }
    public static void main(String[] args){
        Permutation_II permu = new Permutation_II();
        int[] nums = {1,1};
        List<List<Integer>> result = new ArrayList<>();
        result = permu.permuteUnique(nums);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
