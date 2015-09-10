/**
 * Given k strings, find the longest common prefix (LCP).

 Example
 For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"

 For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"

 Tags Expand
 Enumeration Basic Implementation String LintCode Copyright
 */
public class Longest_Common_Prefix {
    //方法一：得到common prefix,不断截取prefix的最小长度
    public String longestCommonPre1(String[]strs){
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
    //方法二：得到最小的那个位置i，截取之前的长度
    public String longestCommonPre2(String[] strs){
        int size = strs.length;
        if(strs==null||size==0)return "";
        if(size==1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        int min = 0;
        for(int i=1;i<size;i++){
            min = Math.min(strs[i-1].length(),strs[i].length());
            if(min==0)return "";
            int j=0;
            while(j<min){
                if(strs[i-1].charAt(j)!=strs[i].charAt(j)){
                    minLen = Math.min(minLen,j);
                    break;
                }

                if(++j==min){
                    minLen = Math.min(minLen,j);
                }

            }

        }
        return strs[0].substring(0,minLen);
    }
}
