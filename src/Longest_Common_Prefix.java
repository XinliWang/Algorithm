/**
 * Given k strings, find the longest common prefix (LCP).

 Example
 For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"

 For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"

 Tags Expand
 Enumeration Basic Implementation String LintCode Copyright
 */
public class Longest_Common_Prefix {
    public String longeseCommonPre(String[]strs){
        if(strs==null||strs.length==0){
            return "";
        }
        int n = strs.length;
        String prefix = strs[0];
        for(int i=1;i<n;i++){
            int j = 0;
            while(j<strs[i].length()&&j<prefix.length()&& prefix.charAt(j)==strs[i].charAt(j)){
                ++j;
            }
            if(j==0)return "";
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}
