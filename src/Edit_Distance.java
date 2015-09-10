/**
 * Given two words word1 and word2,
 * find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 Hide Tags: Dynamic Programming String

 */

/**
 * Solution:
 * 1. f[i][j] represents the number of steps of i characters and j characters
 * 2. if the i-th and j-th element are the same, we don't need change anything, so f[i][j] = f[i-1][j-1]
 * 3. if not same, we need change at least one step.  We have three operations to do that. Choosing the minimum steps and add 1.
 * 4. the last position of word1 and word2 is the answer
 */
public class Edit_Distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        //initialization. word2 is null.
        for(int i=0;i<=m;i++){
            dp[i][0] = i;
        }
        //word1 is null
        for(int j=0;j<=n;j++){
            dp[0][j] = j;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = 1+ Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}
