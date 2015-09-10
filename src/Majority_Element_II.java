import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */
//there exists at most two elements
public class Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        //get two most possible element
        for(int i=0;i<nums.length;i++){
            if(count1==0){
                candidate1 = nums[i];
            }else if(count2==0 && nums[i]!=candidate1){
                candidate2 = nums[i];
            }
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        //get the number of elements appear
        count1 = 0;
        count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == candidate1){
                count1++;
            }
            if(nums[i] == candidate2){
                count2++;
            }
        }
        if(count1>Math.floor(nums.length/3)) list.add(candidate1);
        if(count2>Math.floor(nums.length/3) && candidate1!=candidate2) list.add(candidate2);
        return list;
    }
}

/*
 * cost time = O(n), cost space = O(1)
 */
