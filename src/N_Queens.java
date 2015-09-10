import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement,
 where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 Hide Tags: Backtracking

 */
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        //we use Integer to represent the position of Q
        List<Integer> list = new ArrayList<>();
        helper(lists,list,n);
        return lists;
    }

    //recursive
    private void helper(List<List<String>> lists,List<Integer> list,int n){
        //the matched condition
        if(list.size()==n){
            lists.add(toStringList(list));
            return;
        }

        //traverse every position in every row
        for(int i=0;i<n;i++){
            //judge if it matched the requirement
            if(!isValid(list,i)){
                continue;
            }
            list.add(i);
            helper(lists,list,n);
            list.remove(list.size()-1);
        }
    }
    private boolean isValid(List<Integer> list,int i){
        int row = list.size();
        for(int j=0;j<row;j++){
           //the same column
            if(list.get(j) == i){
                return false;
            }
            //left-top to right-bottom
            if(list.get(j)-j == i-row){
                return false;
            }
            //left-bottom to right-top
            if(list.get(j)+j == i+row){
                return false;
            }
        }
        return true;
    }

    //List<Integer> to List<String>
    private List<String> toStringList(List<Integer> list){
        int size = list.size();
        List<String> newList = new ArrayList<>();
        for(int i=0;i<size;i++){
            String string = "";
            //according to the position to create a string
            for(int j=0;j<size;j++){
                if(list.get(i)==j){
                    string += "Q";
                }else{
                    string += ".";
                }
            }
            newList.add(string);
        }
        return newList;
    }
}
