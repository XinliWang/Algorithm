/**
 * Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
   You may assume no duplicates in the array.
   Here are few examples.
   [1,3,5,6], 5 → 2
   [1,3,5,6], 2 → 1
   [1,3,5,6], 7 → 4
   [1,3,5,6], 0 → 0
 */
public class Search_Insert_Position {
    public int searchInsert(int[] nums,int target){
        int size = nums.length;
        if(size==0||nums==null)return 0;
        for(int i=0;i<size;i++){
            if(nums[i]>=target)return i;
        }
        return size;

    }
}
