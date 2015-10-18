import java.util.HashMap;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */


//HashMap
public class Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        int size = strings.length;
        if(size!= pattern.length()) return false;
        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<size;i++){
            char key = pattern.charAt(i);
            if(map.containsKey(key)){
                if(!map.get(key).equals(strings[i])){
                    return false;
                }
            }else if(map.containsValue(strings[i])){    //in case of a->dog and b->dog.
                return false;
            }else{
                map.put(key,strings[i]);
            }
        }
        return true;
    }
}
