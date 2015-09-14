import java.util.HashMap;
import java.util.HashSet;

/**
 * input 是  一个int array 和 int target value
   outut是 target value 出现了几次 和leecode上的题基本一样,就当input不会有duplicate
   比如[1,2,3,4] target value 是5，那就return 2
 */
public class Two_Pair_Sum {
    //Runtime is O(n^2)
    public int countTwoSum1(int target,int[] array){
        int size = array.length;
        if(array==null || size==0)return 0;
        HashSet set = new HashSet<>();
        for(int i=0;i<size-1;i++){
            for(int j=i;j<size;j++){
                if(target==array[i] + array[j]){
                    int[] newInt = {array[i], array[j]};
                    set.add(newInt);
                }
            }
        }
        return set.size();
    }
    public int countTwoSum2(int target,int[] nums){
        int count=0;
        if(nums==null || nums.length==0)return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                count++;
            }else{
                map.put(nums[i],i);
            }
        }
        return count;
    }

    public static void main(String[] args){
        Two_Pair_Sum pp = new Two_Pair_Sum();
        int[] A = {1,2,3,4,5};
        int t = pp.countTwoSum2(5, A);
        System.out.print(t);
    }
}
