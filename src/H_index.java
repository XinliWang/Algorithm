/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia:
 "A scientist has index h if h of his/her N papers have at least h citations each,
 and the other N − h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5],
 which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each,
 his h-index is 3.

 Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class H_index {
    public int hIndex(int[] citations) {

        int size = citations.length;
        if(size==0) return 0;
        int[] f = new int[size+1];
        //count comparison of each element of array
        for(int i=0;i<size;i++){
            if(citations[i]>size){
                f[size] +=1;
            }else{
                f[citations[i]] +=1;
            }
        }
        int count=0;
        //if there are n elements greater than n, that's answer
        for(int i=size;i>=0;i--){
            count = count + f[i];
            if(count>=i){
                return i;
            }
        }
        return 0;
    }
}
