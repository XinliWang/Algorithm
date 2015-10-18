import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 click to show hint.

 You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

 If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
 What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not?
 How about a Trie? If you would like to learn how to implement a basic trie,
 please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class Word_Search_II {
    //Trie and backtracking
    Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for(int i=0;i<m ;i++){
            for(int j=0;j<n;j++){
                dfs(board,isVisited,trie,i,j,"");
            }
        }
        return new ArrayList<>(set);
    }
    public void dfs(char[][] board,boolean[][] isVisited,Trie trie,int x,int y,String str){
        if(x<0 || x>=board.length || y<0 || y>=board[0].length)return;
        if(isVisited[x][y])return;
        str += board[x][y];
        if(!trie.startsWith(str)) return;
        if(trie.search(str)){
            set.add(str);
        }
        isVisited[x][y]=true;
        dfs(board,isVisited,trie,x,y-1,str);
        dfs(board,isVisited,trie,x,y+1,str);
        dfs(board,isVisited,trie,x-1,y,str);
        dfs(board,isVisited,trie,x+1,y,str);
        isVisited[x][y]=false;
    }
}
