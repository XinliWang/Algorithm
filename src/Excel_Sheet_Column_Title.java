/**
 * My Submissions Question Solution
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class Excel_Sheet_Column_Title {
    //Solution1
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while(n!=0){
            builder.insert(0, n%26==0? 'Z' : (char)(64 + n%26));
            n = (n-1)/26;
        }
        return builder.toString();
    }

    //Solution2
    public String convertToTitle2(int n){
        StringBuilder builder = new StringBuilder();
        while(n>0){
            char c = (char)((n-1)%26 + 'A');
            builder.insert(0,c);
            n = (n-1)/26;
        }
        return builder.toString();
    }

}
