import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Generate_Parentheses {
    //Binary tree and DFS
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfsMthod("(",1,0,n,list);
        return list;
    }
    public void dfsMthod(String s,int left,int right,int size,List<String> list){
        if (left>size || right>size || left<right) return;
        if(left==right && left == size){
            list.add(s);
            return;
        }
        dfsMthod(s+"(",left+1,right,size,list);
        dfsMthod(s+")",left,right+1,size,list);
    }
}
