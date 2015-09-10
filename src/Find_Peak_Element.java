/**
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 click to show spoilers.

 Note:
 Your solution should be in logarithmic complexity.
 */

//二分法找最大值，只需要找其中一个就好
public class Find_Peak_Element {

    public int findPeakElement(int[] nums){
        int size = nums.length;
        int start = 0;
        int end = size-1;
        while(start<end){
            int mid = start + (end - start)/2;
            if(mid<size-1 && nums[mid]>nums[mid+1]){
                end = mid;
            }
            if(mid < size-1 && nums[mid]<nums[mid+1]){
                start = mid+1;
            }
        }
        return start;
    }
}
