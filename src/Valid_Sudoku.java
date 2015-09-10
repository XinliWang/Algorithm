/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.
 */
public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowArray = new boolean[9][9];
        boolean[][] colArray = new boolean[9][9];
        boolean[][] boardArray = new boolean[9][9];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='.'){
                    continue;
                }
                int digit = board[i][j]-'1';

                //judge 3x3 sudoku, i=0,1,2都为0 and j=0,1,2/3,4,5/6,7,8 。下一次从3开始
                int index = i/3 * 3 + j/3;
                if (rowArray[i][digit]){
                    return false;
                }else{
                    rowArray[i][digit] = true;
                }
                if (colArray[j][digit]){
                    return false;
                }else{
                    colArray[j][digit] = true;
                }
                if (boardArray[index][digit]){
                    return false;
                }else{
                    boardArray[index][digit] = true;
                }
            }
        }
        return true;
    }

}
