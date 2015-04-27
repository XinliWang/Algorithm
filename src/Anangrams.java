import java.util.*;
/**
 * Given an array of strings, return all groups of strings that are anagrams.

 Example
 Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

 Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

 Note
 All inputs will be in lower-case

 Tags Expand
 String Hash Table
 */
public class Anangrams {
    public List<String> anagrams(String[] strs){
        int n = strs.length;
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String temp = Arrays.toString(ch);
            if(map.containsKey(temp)){
                list.add(strs[i]);
                if(map.get(temp)!=-1){
                    list.add(strs[map.get(temp)]);
                    map.put(temp,-1);
                }
            }else{
                map.put(temp,i);
            }
        }
        return list;
    }
}
