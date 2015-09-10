import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(k,n,lists,list,0,1);
        return lists;
    }
    public void helper(int k,int n,List<List<Integer>> lists,List<Integer> list,int sum,int start){
        if (k==list.size() && sum == n){
            lists.add(list);
        }
        if(k < list.size() || sum > n) return;
        for (int i = start; i <=9 ;i++){
            sum += i;
            if (sum>n){
                break;
            }else{
                list.add(i);
                helper(k,n,lists,list,sum,i+1);
                list.remove(list.size()-1);
                sum -= i;
            }
        }
    }
}
