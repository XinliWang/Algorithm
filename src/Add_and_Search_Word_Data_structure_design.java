/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.

 click to show hint.

 You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class Add_and_Search_Word_Data_structure_design {
    class WordNode{
        private Boolean isWord = false;
        private WordNode[] childen = new WordNode[26];
        public WordNode(){}
    }
    private WordNode root;
    public Add_and_Search_Word_Data_structure_design(){
        root = new WordNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        WordNode node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.childen[c-'a']==null){
                node.childen[c-'a'] = new WordNode();
            }
            node = node.childen[c-'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfsSearch(word,0,root);
    }

    private boolean dfsSearch(String word,int index,WordNode node){
        if(index == word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(dfsSearch(word,index+1,node.childen[i])){
                    return true;
                }
            }
            return false;
        }
        if (node.childen[c-'a']==null)return false;
        return dfsSearch(word,index+1,node.childen[c-'a']);
    }
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");