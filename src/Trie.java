/**
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 它有3个基本性质：
 根节点不包含字符，除根节点外每一个节点都只包含一个字符； 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串； 每个节点的所有子节点包含的字符都不相同。
 搜索字典项目的方法为：
 (1) 从根结点开始一次搜索；
 (2) 取得要查找关键词的第一个字母，并根据该字母选择对应的子树并转到该子树继续进行检索；
 (3) 在相应的子树上，取得要查找关键词的第二个字母,并进一步选择对应的子树进行检索。
 (4) 迭代过程……
 (5) 在某个结点处，关键词的所有字母已被取出，则读取附在该结点上的信息，即完成查找。
 其他操作类似处理


 这题主要考察Trie 即前缀树的实现，Trie可以用于字典的压缩存储，可以节省空间，但是不节省时间（和HashSet相比）。
 这题实质是实现一颗多叉树（分支因子26）的插入和查找操作。定义每个TrieNode保存char c，保存一个HashMap用于储存所有的孩子节点，
 key是对应的字符，value是孩子节点，定义flag hasWord来标记这个node上是否存在word。对于插入操作，直接从上向下分层扫描树，
 如果没有对应字符节点存在就新建节点，如果有就去相应路径向下探察。对于查询操作，前缀树的定义可以保证当我们从前向后扫描字符串时候，
 每一个字符都可以从上到下对应前缀树的每一层，所以扫描过程中如果有任何一个字符不存在于当前层中，就可以立刻停止查找返回null，
 也就是不存在这样的word或者前缀，否则继续从对应的分支向下探察。时间复杂度是O（L），L是树的高度，也就是最长word的长度，
 空间复杂度26^L，每一层分支因子26，有L层。



 */




class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode(){}

}

public class Trie{
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ws.children[ch-'a']==null){
                ws.children[ch-'a'] = new TrieNode();
            }
            ws = ws.children[ch-'a'];
        }
        ws.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ws.children[ch-'a']==null) return false;
            ws = ws.children[ch-'a'];
        }
        return ws.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(ws.children[ch-'a']==null) return false;
            ws = ws.children[ch-'a'];
        }
        return true;
    }
}
