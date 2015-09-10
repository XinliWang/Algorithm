/**
 * Given an array S of n integers, find three integers in S
 * such that the sum is closest to a given number, target.
 * Return the sum of the three integers.

 Example
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 Note
 You may assume that each input would have exactly one solution.

 Challenge
 O(n^2) time, O(1) extra space

 Tags Expand
 Two Pointers Sort Array
 */
public class Sum3_Closet {
    public int threeSumClosest(int[]num,int target){
        int size = num.length;
        if(num==null || size<3)return 0;
        int min = Integer.MAX_VALUE;
        int result = 0;

        for(int i=0;i<size;i++){
            int left = i +1;
            int right = size-1;
            while(left<right){
                int sum = num[i] + num[left] + num[right];
                if(sum == target) return target;
                else if(sum > target){
                    --right;
                }else{
                    ++left;
                }
                if(min>Math.abs(sum - target)){
                    min = Math.abs(sum - target);
                    result = sum;
                }
            }
        }
        return result;
    }


    //该方法leetcode不知道为什么通不过
    public int closestSum(int[]num,int target){
        if(num==null||num.length<3)return Integer.MAX_VALUE;
        int closet = Integer.MAX_VALUE;
        for(int i=0;i<num.length-1;i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int result = num[i] + num[left] + num[right];
                if (result == target) {
                    return result;
                } else if (result < target) {
                    ++left;
                } else {
                    --right;
                }
                closet = Math.abs(result - target) > Math.abs(closet - target) ? closet : result;
            }
        }
        return closet;
    }
}

    /**
     *  O(n) = n^2 ;
     */
