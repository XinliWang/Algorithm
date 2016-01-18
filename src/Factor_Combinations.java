import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 8 = 2 x 2 x 2;
   = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:
 Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.
 Examples:
 input: 1
 output: []
 input: 37
 output: []
 input: 12
 output:
 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]
 input: 32
 output:
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 Hide Company Tags: LinkedIn
 Hide Tags: Backtracking
 */
public class Factor_Combinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<>();
        if(n<=3)return lists;
        List<Integer> list = new ArrayList<>();
        getAllFactors(n,lists,list);
        return lists;
    }

    public void getAllFactors(int n,List<List<Integer>> lists,List<Integer> list){
        if(n<=3)return;
        for(int i=2;i*i<=n;i++){
            if(list.size()==0 || list.size()>0 && list.get(list.size()-1)<=i){
                if(n%i==0){
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(i);
                    temp.add(n/i);
                    lists.add(temp);
                    
                    //backtracking
                    list.add(i);
                    getAllFactors(n/i,lists,list);
                    list.remove(list.size()-1);
                }
            }
        }

    }
}
