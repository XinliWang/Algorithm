/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 If the last word does not exist, return 0.
 Note: A word is defined as a character sequence consists of non-space characters only.
 For example,
 Given s = "Hello World",
 return 5.
 */
public class Length_of_Last_Word {
    public int lengthOfLastWord(String s){
        String str = s.trim();
        if(str=="") return 0;
        String [] arr = str.split(" ");
        return arr[arr.length-1].length();
    }
}
