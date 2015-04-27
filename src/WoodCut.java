import java.util.Arrays;

/**
 * Given n pieces of wood with length L[i] (integer array).
 * Cut them into small pieces to guarantee you could have
 * equal or more than k pieces with the same length.
 * What is the longest length you can get from the n pieces of wood?
 * Given L & k, return the maximum length of the small pieces.

 Example
 For L=[232, 124, 456], k=7, return 114.

 Note
 You couldn't cut wood into float length.

 Challenge
 O(n log Len), where Len is the longest length of the wood.

 Tags:Binary Search
 */
public class WoodCut {
    public int woodCut(int[] L, int k) {
        // write your code here
        int n=L.length;
        if(n==0){
           return 0;
        }

        Arrays.sort(L);


        int res=0;
        int start=1, end=L[n-1];

        while(start<=end){
            int mid=(end+start)/2;
            int count=0;

            for(int i=0 ;i<n ; i++){
                count+=(L[i]/mid);
            }

            if(count>=k){
                res=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return res;
    }




}







