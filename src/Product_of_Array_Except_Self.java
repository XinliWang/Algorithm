/**
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity?
 (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */

/**
 * Solution:
 * 1. from the second element to the last one, each time multiply the previous part
 * 2. At this time the last element has done
 * 3. Then from the last second element to the first one, each time multiply the later part
 */
public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] productNums = new int[size];
        int right = 1;
        productNums[0] = 1;
        for (int i=1;i<size;i++){
            productNums[i] = productNums[i-1] * nums[i-1];
        }
        for (int j=size-2;j>=0;j--){
            right *= nums[j+1];
            productNums[j] *= right;
        }
        return productNums;
    }
}
