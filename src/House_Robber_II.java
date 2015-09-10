/**
 * Note: This is an extension of House Robber.

 After robbing those houses on that street,
 the thief has found himself a new place for his thievery so that he will not get too much attention.
 This time, all houses at this place are arranged in a circle.
 That means the first house is the neighbor of the last one.
 Meanwhile, the security system for these houses remain the same as for those in the previous street.
 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class House_Robber_II {
    /**
     *  1. Using two solutions, then compare their value
     *  2. the first solution is robbing from the first house and stop to the last but one house
     *  3. the second solution is robbing form the second house and stop to the last one house
     */
    public int rob(int[] nums){
        int size = nums.length;
        if (size==0) return 0;
        if (size==1) return nums[0];
        if (size==2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[size];

        //rob from the first house
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i=2;i<size;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int first = dp[size-2];

        //rob from the second house
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i=2;i<size;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        int second = dp[size-1];
        return Math.max(first,second);
    }

}
