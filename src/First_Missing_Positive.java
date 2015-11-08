/**
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        while(start<=end){
            int index = nums[start]-1;
            //如果符合条件，则前移一位
            if(index==start){
                start++;
            }
            //如果是不符合条件的数，则用最后一位把start这个数覆盖掉
            else if(index<0 || index>end || nums[start]!=nums[index]){
                nums[start] = nums[end--];
            }
            //如果是不在正确位置上的数
            else{
                nums[start] = nums[index];
                nums[index] = index+1;
            }

        }
        return start+1;
    }
}
