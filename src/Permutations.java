import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums){
        LinkedList<List<Integer>> list = new LinkedList<>();
        int size = nums.length;
        if (size==0 || nums==null){
            return list;
        }
        list.add(new LinkedList<Integer>());
        for (int i=0;i<size;i++){
            int length = list.size();
            while(length>0){
                LinkedList<Integer> temp = new LinkedList<>();
                for (int j=0;j<temp.size();j++){
                    LinkedList<Integer> newList = new LinkedList<>(temp);
                    newList.add(j,nums[i]);
                    list.add(newList);
                }
                temp.add(nums[i]);
                list.add(temp);
                length--;
            }
        }
        return list;
    }
}
