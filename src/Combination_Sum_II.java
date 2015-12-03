import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 */
public class Combination_Sum_II {
    /**
     * Solution1:use HashSet to remove duplicate list, then convert hashset to list
     * HashSet<List<Integer>> set = new HashSet<>();
     * List<List<Integer>> list = new ArrayList<>(set);
     */
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        HashSet<List<Integer>> set = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        getTarget(candidates,target,set,list,0,0);
        List<List<Integer>> lists = new ArrayList<>(set);
        return lists;
    }
    public void getTarget(int[] candidates, int target,HashSet<List<Integer>> set,List<Integer> list,int sum,int start){
        if(sum == target){
            set.add(new ArrayList<Integer>(list));
        }
        if(sum<target && start<candidates.length){
            for(int i=start;i<candidates.length;i++){
                sum += candidates[i];
                if (sum > target){
                    break;
                }else{
                    list.add(candidates[i]);
                    getTarget(candidates,target,set,list,sum,i+1);
                    list.remove(list.size()-1);
                    sum -= candidates[i];
                }
            }
        }

    }

    /**
     * Solution2:
     * Recursive solution, in each loop, we only allow the first step is duplicate
     */
    public List<List<Integer>> combinationSumII2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, target, lists, list, 0);
        return lists;
    }
    private void helper(int[] candidates, int target,List<List<Integer>> lists,List<Integer> list,int start){
        if(target==0){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        if(target<0 || start==candidates.length) return;
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i+1]) continue;
            list.add(candidates[i]);
            helper(candidates,target-candidates[i],lists,list,i+1);
            list.remove(list.size()-1);
        }
    }

}
