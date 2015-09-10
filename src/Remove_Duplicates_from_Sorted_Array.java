/**
 * Given a sorted array, remove the duplicates in place such that
 * each element appear only once and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.
 For example,
 Given input array nums = [1,1,2],
 Your function should return length = 2,
 with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class Remove_Duplicates_from_Sorted_Array {
    //方法一：粗暴解法：一个一个比较，当有不同的时候，让后面所有的元素全部向前替换一位.然后总长度减1，继续比较
    public int removeDuplicates1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int j = 0;
        int count = nums.length;
        for(int i=0;i<count-1;i++){
            if(nums[i]==nums[i+1]){

                j = i;
                i--;
                while(j<count-1){
                    nums[j] = nums[j+1];
                    j++;
                }
                --count;
            }
        }
        return count;
    }

    //方法二：
    public int removeDuplicates2(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int pre = nums[0];
        int cur = 0;
        int index=1;
        for(int i=1;i<nums.length;i++){
            cur = nums[i];
            if(pre!=cur){
                pre = cur;
                nums[index] = cur;
                index++;
            }
        }
        return index;
    }


    public static void main(String[]args){
        Remove_Duplicates_from_Sorted_Array r = new Remove_Duplicates_from_Sorted_Array();
        int[] ar ={1,1};
        System.out.print(r.removeDuplicates1(ar));

    }
}
