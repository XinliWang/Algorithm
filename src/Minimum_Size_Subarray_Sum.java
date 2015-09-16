/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int size = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while(right<size){
            /**
             *  1.if sum add the next element is less than s, we add it and move right
             *  2.if greater than s, we save the minimum length and move left, then sum decreases.
             *  3.Since we remove the left element,however we haven't added the right element.
             *   the sum must be less than s. In the next loop, it will add right element and move right.
             */

            if(sum+nums[right]<s){
                sum += nums[right];
                right++;
            }else{
                minLength = Math.min(minLength,right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE? 0 : minLength;
    }
}

/**
 *  Runtime is O(m+n);
 */
