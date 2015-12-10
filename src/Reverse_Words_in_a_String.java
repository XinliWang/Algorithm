/**
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 */
public class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        if(s.length()==0)return "";
        StringBuilder builder = new StringBuilder();
        //we use regexp to express multiple blanks
        String[] strings = s.trim().split("\\s{1,}");
        for(int i=strings.length-1;i>=0;i--){
            builder.append(strings[i]).append(" ");
        }
        return builder.toString().trim();
    }

}
