/**
 * Given a list of integers, which denote a permutation.

 Find the next permutation in ascending order.

 Example
 For [1,3,2,3], the next permutation is [1,3,3,2]

 For [4,3,2,1], the next permutation is [1,2,3,4]

 Note
 The list may contains duplicate integers.

 Tags Expand
 LintCode Copyright Permutation
 */
public class Next_Permutation {
    /**
     * 思路：此题是从后往前查询，找出非递增的第一个数，此数为p，位置为i，
     * 然后比较从后往前比较到i+1位置的数，找出第一个大于p的数，调换两个数的位置，
     * 再改变i+1到最后一个数的顺序，即为下一个permutation.
     * Notice: 如果从后往前全部递增，则直接改变所有数的顺序即为下一个permutation
     */
    public int[] nextPermutation(int[] nums){
        int size = nums.length;
        for(int i=size-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                for(int j=size-1;j>i;j--){
                    if(nums[i]<nums[j]){
                        swap(nums,i,j);
                        break;
                    }
                }
                reverse(nums,i+1,size-1);
                return nums;
            }
        }
        reverse(nums,0,size-1);
        //Arrays.sort(nums,i,size);
        return nums;
    }

    //调换两个数
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //调换顺序
    private void reverse(int[] nums,int i, int j){
        for(int m=i,n=j; m<n; m++,n--){
            swap(nums,m,n);
        }
    }
}
