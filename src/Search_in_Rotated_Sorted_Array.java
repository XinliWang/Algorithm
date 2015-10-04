/**
 *Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Search_in_Rotated_Sorted_Array {
    //Solution1: O(n) runtime
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int index = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Solution2:O(lgn) runtime
     * Binary Search
     */

    public int search2(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        return binarySearch(0,nums.length-1,nums,target);
    }
    private int binarySearch(int start,int end,int[] nums,int target){
        int mid = start+(end-start)/2;
        if(nums[mid]==target)return mid;
        if(start>end)return -1;
        //mid is in the left side
        if(nums[mid]>=nums[start]){
            if(nums[mid]>target && target>=nums[start]){
                return binarySearch(start,mid-1,nums,target);
            }else{
                return binarySearch(mid+1,end,nums,target);
            }
        }else{
            //mid is in the right side
            if(nums[end]>=target && target>nums[mid]){
                return binarySearch(mid+1,end,nums,target);
            }else{
                return binarySearch(start,mid-1,nums,target);
            }
        }
    }
}
