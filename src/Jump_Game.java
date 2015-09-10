/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class Jump_Game {
    public boolean canJump(int[] nums) {
        /**
         * Solution1:
         * if the maximum of nums[i]+i could reach the last element, return true;
         * otherwise return false.
         */
        int reachable = 0;
        for(int i=0;i<nums.length;i++){
            if(reachable>i)return false;
            reachable = Math.max(reachable,nums[i]+i);
        }
        return true;
    }

    /**
     * Solution2:
     * Dynamic programming
     */
    public boolean canJump2(int[] nums){
        int size = nums.length;
        boolean[] f = new boolean[size];
        f[0] = true;
        for (int i=1;i<size;i++){
            for(int j=0;j<i;j++){
                if(f[j] && nums[j]+j>i){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[size-1];
    }
}
