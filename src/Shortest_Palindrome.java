/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".
 */


/**
 * The main idea is finding the point and reverse the remain part as prefix to
 */
public class Shortest_Palindrome {
    public String shortestPalindrome(String s) {
        int i=0;
        int end = s.length()-1;
        int j=end;
        char[] arr = s.toCharArray();
        while(i<j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }else{
                i = 0;
                //find the prefix which the first part doesn't have
                end--;
                j = end;
            }
        }
        //reverse the remain part as prefix to s   ,  aabaaa =>  a + aabaaa
        return new StringBuilder(s.substring(end+1)).reverse().toString()+s;
    }
}
