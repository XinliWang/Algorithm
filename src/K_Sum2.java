import java.util.ArrayList;
/**
 *Given n unique integers, number k (1<=k<=n)  and target.
 *Find all possible k integers where their sum is target.

 Example
 Given [1,2,3,4], k=2, target=5, [1,4] and [2,3] are possible solutions.

 Tags Expand
 LintCode Copyright Depth First Search
 */
public class K_Sum2 {
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        helper(A,lists,list,k,target,0);
        return lists;
    }
    private void helper(int A[],ArrayList<ArrayList<Integer>> lists ,ArrayList<Integer> list, int k, int target, int start){
        if(k<0||target<0)return;
        if(k==0 && target==0){
            //in order to create new list,otherwise list will have more elements
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<A.length;i++){
            list.add(A[i]);
            helper(A,lists ,list, k-1,target-A[i], i+1);
            list.remove(list.size()-1);

        }
    }
}
