import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int size = arr.length;
        if(size==0)return 0;
        int maxInt = 1;
        int index = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<size;i++){
            if(!set.add(arr[i])){
                maxInt = Math.max(maxInt,set.size());
                while(!set.add(arr[i])){
                    set.remove(arr[index]);
                    index++;
                }
            }
        }
        return Math.max(maxInt,set.size());
    }
}
