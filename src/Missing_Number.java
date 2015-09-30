import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity.
 Could you implement it using only constant extra space complexity?


 Hide Tags: Array Math Bit Manipulation

 */
public class Missing_Number {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]!=0)return 0;
        int size = nums.length;
        for(int i=0;i<size-1 ;i++){
            if(nums[i]+1!=nums[i+1]){
                return nums[i]+1;
            }
        }
        return nums[size-1]+1;
    }
}
