/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
  \       /     /      / \      \
   3     2     1      1   3      2
  /     /       \                 \
 2     1         2                 3
 */
public class Unique_Binary_Search_Tree {
    //DP
    public int numTrees(int n){
        int[] G = new int[n+1];
        //initialize
        G[0] = 1;
        G[1] = 1;
        /**
         * 1. we need calculate G[n].
         * 2. each time we need use every element to be a root
         */

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                G[i] += G[j] * G[i-j-1];
            }
        }
        return G[n];
    }
}
