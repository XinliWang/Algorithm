/**
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.

 Hide Tags: Array Binary Search

 */
public class Search_in_Rotated_Sorted_ArrayII {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0)return false;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+ (end-start)/2;
            if(nums[mid]==target){
                return true;
            }
            /**
             * the array may have two part.if mid is in the first part
             */
            if(nums[mid]>nums[end]){
                if(nums[start]<=target && target<nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(nums[mid]<nums[end]){     //mid is in the last part
                if(nums[mid]<target && target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                end--;
            }

        }
        return false;
    }
}
