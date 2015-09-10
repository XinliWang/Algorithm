/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.However, if duplicate exists, the code is still correct.
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums){
        int size = nums.length;
        int min = nums[0];
        for (int i=0;i<size-1;i++){
            if (nums[i]>nums[i+1]){
                min = nums[i+1];
            }
        }
        return min;
    }
}
