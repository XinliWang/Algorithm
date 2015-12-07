import java.util.HashMap;

/**
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.
 */
public class Remove_Duplicates_from_Sorted_ArrayII {
    /**
     * 1.use a pointer to insert element
     * 2.we insert element each time
     * 3.if this element appears more than twice,we use pointer stay in that position
     * 4.continue to next loop.
     */

    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int index=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])==2){
                    continue;
                }else{
                 //   map.replace(nums[i],map.get(nums[i])+1);
                }
            }else{
                map.put(nums[i],1);
            }
            nums[index] = nums[i];
            index++;
        }
        return index;
    }
}
