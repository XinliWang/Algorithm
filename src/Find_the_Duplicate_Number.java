/**
 *Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 Hide Tags: Array, Two Pointers, Binary Search

 */
public class Find_the_Duplicate_Number {
    /**
     * Solution1:
     * 1. using Binary Search to count the number is not greater than mid
     * 2. if count is not greater than mid, then start = mid +1;otherwise,end = mid-1
     * 3. at last,return start
     * https://leetcode.com/discuss/60830/python-solution-explanation-without-changing-input-array
     */
    public int findDuplicate(int[] nums) {
        if(nums==null || nums.length<2)return 0;
        int size = nums.length;
        int start = 1;
        int end = size-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int count=0;
            for(int num:nums){
                if(num<=mid){
                    count++;
                }
            }
            if(count<=mid){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }
    public static void main(String[] args){
        Find_the_Duplicate_Number f = new Find_the_Duplicate_Number();
        int[] a = {1,2,3,4,4};
        System.out.print(f.findDuplicate(a));
    }


    /**
     * Solution2: Using slow and fast pointer
     *http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
     */

}
