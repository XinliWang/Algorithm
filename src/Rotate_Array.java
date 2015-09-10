/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class Rotate_Array {
    public void rotate(int[] nums, int k) {
        int size =nums.length;
        k = k % size;
        if (k==0 || size<=1) return;
        int [] newNum = new int[size];
        int x = 0;
        for (int i=size-k;i<size;i++){
            newNum[x] = nums[i];
            x++;
        }
        for (int i=0;i<size-k;i++){
            newNum[x] = nums[i];
            x++;
        }
        for (int j=0;j<size;j++){
            nums[j] = newNum[j];
        }
    }
}
