import java.util.Set;

/**
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 Hide Tags:Dynamic Programming

 */
public class Word_Break {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.length()==0)return false;
        int size = s.length();
        boolean[] dp = new boolean[size];
        for (int i=0;i<size;i++){
            for(int j=0;j<=i;j++){
                /**
                 * 1. each time we judge if a string from start to index is a word
                 * 2. if so, then if previous string is a word too(dp[start-1]=true), then dp[i] = true and we go on a new start
                 * 3. if not, continue to traverse the string
                 */

                if(wordDict.contains(s.substring(j,i+1)) && (j==0 || dp[j-1])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[size-1];
    }
}
