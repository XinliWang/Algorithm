import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 Hide Tags: Backtracking

 */
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s,0,list,lists);
        return lists;
    }
    //backtracking
    private void helper(String s,int index,List<String> list,List<List<String>> lists){
        if(index>=s.length()){
            //Notice: we must use new ArrayList to add this list
            lists.add(new ArrayList<String>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                helper(s,i+1,list,lists);
                list.remove(list.size()-1);
            }
        }
    }

    //judge if the sub string is palindrome
    private boolean isPalindrome(String s, int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
