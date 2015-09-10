import java.util.ArrayList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.

 Example
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

 (-1, 0, 0, 1)

 (-2, -1, 1, 2)

 (-2, 0, 0, 2)

 Note
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)

 The solution set must not contain duplicate quadruplets.

 Tags Expand
 Two Pointers Sort Hash Table Array
 */
public class Sum4 {
        public List<List<Integer>> fourSum(int[] nums,int target){
            ArrayList<List<Integer>> list = new ArrayList<>();
            int size = nums.length;
            if(nums == null && size<4){
                return list;
            }
            for(int i=0;i<size-3;i++){
                for(int j=i+1;j<size-2;j++){
                    int left = j+1;
                    int right = size -1;
                    while(left<right){
                        int sum = nums[i] + nums[j] +nums[left]+nums[right];
                        if(sum == target){
                            ArrayList<Integer> subList = new ArrayList<>();
                            subList.add(nums[i]);
                            subList.add(nums[j]);
                            subList.add(nums[left]);
                            subList.add(nums[right]);
                            if(!list.contains(subList)){
                                list.add(subList);
                            }
                            left++;
                            right--;
                        }else if(sum>target){
                            --right;
                        }else{
                            ++left;
                        }
                    }
                }
            }
            return list;
        }

}
