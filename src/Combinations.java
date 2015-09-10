import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */

//DFS and backtracking
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n,k,lists,list,1);
        return lists;
    }
    public void helper(int n, int k,List<List<Integer>> lists,List<Integer> list,int start){
        if(list.size() == k){
            lists.add(list);
        }
        if(list.size()>k || start>n) return;
        for(int i=start;i <= n;i++){
            list.add(i);
            helper(n,k,lists,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
