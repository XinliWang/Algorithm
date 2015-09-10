/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2.
 (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Jump_Game_II {
    public int jump(int[] nums) {
        int size = nums.length;
        int curMax = 0;
        int i=0;
        int jumpNum = 0;

        while(curMax<size-1){
            int lastMax = curMax;
            //In every step, we need calculate the maximum distance
            for(; i<lastMax; i++){
                curMax = Math.max(nums[i]+i,curMax);
            }
            jumpNum++;
            //if distance of every step is the same, we won't get to the last element
            if(lastMax == curMax){
                return -1;
            }
        }
        return jumpNum;
    }
}
