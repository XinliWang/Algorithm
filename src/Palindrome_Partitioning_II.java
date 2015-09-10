/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 Hide Tags: Dynamic Programming

 */
public class Palindrome_Partitioning_II {
    //initialize
    private boolean[][] getPalindrome(String s){
        //isPalindrome[position][length]
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            isPalindrome[i][i] = true;
        }
        for(int i=0;i<s.length()-1;i++){
            isPalindrome[i][i+1] = (s.charAt(i)==s.charAt(i+1));
        }
        for(int size=2;size<s.length();size++){
            for(int start=0;start+size<s.length();start++){
                isPalindrome[start][start+size] = isPalindrome[start+1][start+size-1] && (s.charAt(start)==s.charAt(start+size));
            }
        }
        return isPalindrome;
    }

    public int minCut(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        boolean[][] isPalindrome = getPalindrome(s);

        //initialize
        int[] f = new int[s.length()+1];
        for(int i=0;i<=s.length();i++){
            f[i] = i-1;
        }

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(isPalindrome[j][i-1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()];
    }


}
