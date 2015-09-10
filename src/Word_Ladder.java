import java.util.HashSet;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class Word_Ladder {
    //BFS:Breadth-first-search
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        //set1 is beginning result
        Set<String> set1 = new HashSet<>();
        //set2 is ending result
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        return helper(wordDict,set1,set2,1);
    }
    private int helper(Set<String> wordDict,Set<String> set1,Set<String> set2,int level){
        if(set1.isEmpty())return 0;
        //in order to avoid the duplicate word
        for (String word:set1){
            wordDict.remove(word);
        }
        for (String word:set2){
            wordDict.remove(word);
        }
        //BFS
        Set<String> set = new HashSet<>();
        for(String str : set1){
            for(int i=0;i<str.length();i++){
                char[] chars = str.toCharArray();
                for(char ch = 'a';ch<='z';ch++){
                    //traverse every character one time and change to other words
                    chars[i] = ch;
                    String s = new String(chars);
                    if(set2.contains(s)){
                        return level+1;
                    }
                    if(wordDict.contains(s)){
                        set.add(s);
                    }
                }
            }
        }
        //the next level
        return helper(wordDict, set, set2,level+1);
    }
}
