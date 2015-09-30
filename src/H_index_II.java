/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

 Hint:

 Expected runtime complexity is in O(log n) and the input is sorted.
 Hide Tags: Binary Search

 */

/**
 * Solution:
 * The idea is to search for the first index from the sorted array so that :
   citations[index] >= length(citations) - index.
   And return (length - index) as the result. Here is the code:
 */
public class H_index_II {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0){
            return 0;
        }
        int size = citations.length;
        int start = 0;
        int end = size-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(citations[mid]==size-mid){
                return size-mid;
            }else if(citations[mid]<size-mid){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return size-start;
    }
}
