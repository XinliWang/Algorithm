/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 */
//把0放前面，用indexRed标识，把2放后面，用indexBlue标识，其余的为1
public class Sort_Colors {
    public void sortColors(int[] nums) {
        int size = nums.length;
        int indexRed = 0;
        int indexBlue = size-1;
        int i=0;
        while(i<indexBlue+1){
            if(nums[i]==0){
                nums[i] = nums[indexRed];
                nums[indexRed] = 0;
                indexRed++;
                i++;
            }else if(nums[i]==2){
                nums[i] = nums[indexBlue];
                nums[indexBlue] = 2;
                indexBlue--;
            }else if(nums[i]==1){
                i++;
            }
        }
    }
}
