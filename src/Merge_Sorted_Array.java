/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to
 hold additional elements from nums2. The number of elements initialized in nums1 and nums2
 are m and n respectively.
 */

//从后往前、最大到最小依次排列，直到n排列完为止，因为剩下的都会为nums1的值
public class Merge_Sorted_Array {
    public void merge(int[] nums1,int m,int[] nums2,int n){
        if(n==0)return;
        while(n>0){
            if(m==0){
                nums1[n+m-1] = nums2[n-- -1];
            }else{
                nums1[n+m-1] = nums1[m-1]>nums2[n-1]?nums1[m-- -1]:nums2[n-- -1];
            }
        }
    }
}
