/**
 * Given an array of integers,
 * find a contiguous subarray which has the largest sum.

 Example
 For example, given the array [−2,2,−3,4,−1,2,1,−5,3],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 Note
 The subarray should contain at least one number

 Challenge
 Can you do it in time complexity O(n)?

 Tags Expand
 Array Subarray Greedy Enumeration LintCode Copyright
 */
public class Maximum_Subarray {
    public int maximumSum(int[] nums){
        int n = nums.length;
        int[] local = new int[n];
        local[0] = nums[0];
        int[] global = new int[n];
        global[0] = nums[0];
        for(int i=1;i<n;i++){
            local[i] = Math.max(nums[i],local[i-1]+nums[i]);
            global[i] = Math.max(local[i],global[i-1]);
        }
        return global[n-1];
    }
}
