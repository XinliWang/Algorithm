/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.
 */
public class Sudoku_Solver {
    //backtracking
    public void solveSudoku(char[][] board) {
        if(board==null || board.length==0) return ;
        solve(board);
    }
    private static boolean solve(char[][] board){
        for(int i = 0;i < board.length; i++){
            for(int j = 0; j<board[0].length ; j++){
                if(board[i][j]=='.'){
                    for(char c = '1';c <= '9' ; c++){
                        if(isValid(board,i,j,c)){    //judge if we can insert c
                            board[i][j] = c;
                            if(solve(board)){       //DFS
                                return true;
                            }else{
                                board[i][j] = '.';       //backtracking
                            }
                        }
                    }
                    return false;    //if there is no character matching
                }
            }
        }
        return true;   //finishing it
    }
    private static boolean isValid(char[][] board,int col,int row,char c){
        //judge if there is no c in the specific row
        for(int i = 0;i < 9; i++){
            if(board[i][row]==c){
                return false;
            }
        }
        //judge if there is no c in the specific col
        for(int i = 0;i < 9; i++){
            if(board[col][i]==c){
                return false;
            }
        }
        //judge if there is no c in specific ceil
        for(int i=(col/3)*3; i < (col/3)*3 +3; i++){
            for(int j=(row/3)*3; j < (row/3)*3 +3; j++){
                if(board[i][j]==c){
                    return false;
                }
            }
        }
        return true;

    }


}
