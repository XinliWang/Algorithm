/**
 * Find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.

 Example
 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 Tags Expand
 Dynamic Programming Subarray
 */
public class Maximum_Product_Subarray {
    public int maximumProduct(int[]nums){
        int n = nums.length;
        int[] localMax = new int[n];
        int[] localMin = new int[n];
        int[] global = new int[n];
        localMax[0] = localMin[0] = global[0];
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                localMax[i] = Math.max(localMin[i-1]*nums[i],nums[i]);
                localMin[i] = Math.min(localMax[i-1]*nums[i],nums[i]);
            }else{
                localMax[i] = Math.max(localMax[i-1]*nums[i],nums[i]);
                localMin[i] = Math.min(localMin[i-1]*nums[i],nums[i]);
            }
            global[i] = Math.max(localMax[i],global[i-1]);
        }
        return global[n-1];
    }
}
