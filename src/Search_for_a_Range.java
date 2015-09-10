/**
 * Given a sorted array of integers,
 * find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
//Using binary search
public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        int start = 0;
        int end = size-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                int left = mid;
                int right = mid;
                while(left>=0 && nums[left]==target){
                    left--;
                }
                while(right<=size-1 && nums[right]==target){
                    right++;
                }
                return new int[]{left+1,right-1};
            }else if(nums[mid]>target){
                end = mid -1;
            }else if(nums[mid]<target){
                start = mid +1;
            }

        }
        return new int[]{-1,-1};

    }

}
