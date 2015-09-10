import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.

 Hide Tags: Backtracking Math

 */
public class Permutation_Sequence {
    //get the result of n!
    public int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }
    public String getPermutation(int n, int k) {
        String s ="";
        if(n==0) return s;
        List<Integer> list = new ArrayList<>();
        //in order to get and remove more conveniently
        for(int i=0;i<=n;i++){
            list.add(i);
        }

        int temp;
        int index;
        //k-th represents every character could get from k/ i! , then k = k%i!(if k==i!,then k = i!)
        for(int j=n;j>0;j--){
            temp = factorial(j-1);
            index = (int)Math.ceil(k/(double)temp);
            s += list.get(index);
            list.remove(index);
            k = k%temp;
            if(k==0) k = temp;
        }
        return s;
    }
}
