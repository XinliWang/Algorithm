/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class Implement_strStr {
    public int strStr(String haystack,String needle){
        int haySize = haystack.length();
        int neeSize = needle.length();
        for(int i=0;i <= haySize-neeSize;i++){
            if(haystack.substring(i,i+neeSize).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
