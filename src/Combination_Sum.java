import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 */

// DFS
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getTarget(candidates,target,lists,list,0,0);
        return lists;
    }
    public void getTarget(int[] candidates, int target,List<List<Integer>> lists,List<Integer> list, int sum,int start){
        if (sum == target) lists.add(new ArrayList<Integer>(list));
        for (int i=start;i<candidates.length;i++){
            if(sum > target) break;
            else{
                list.add(candidates[i]);
                getTarget(candidates,target,lists,list,sum,start);
                list.remove(list.size()-1);
                sum -= candidates[i];
            }
        }
    }
}
