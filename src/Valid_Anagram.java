import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Valid_Anagram {
    //use haspMap , 53ms
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,1);
            }else{
               // map.replace(c,1+map.get(c));
            }
        }

        for (int j=0;j<t.length();j++){
            char c = t.charAt(j);
            if (!map.containsKey(c)){
                return false;
            }else{
                if(map.get(c)<1)return false;
               // map.replace(c,map.get(c)-1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            if((int)entry.getValue()!=0)return false;
        }
        return true;
    }
    //use array , 8ms
    public boolean isAnagram2(String s, String t){
        if(s.length()!=t.length())return false;
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            //a is 97 , b is 98
            int c = (int)s.charAt(i)-97;
            arr[c] += 1;
        }
        for(int j=0;j<t.length();j++){
            int c2 = (int)t.charAt(j)-97;
            arr[c2] = arr[c2]-1;
        }
        for(int h = 0;h<26;h++){
            if(arr[h]!=0)return false;
        }
        return true;
    }
}
