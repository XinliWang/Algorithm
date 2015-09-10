/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 */
public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //use O(1) space
        boolean rowZero = false;
        boolean colZero = true;

        /**
         * if one element is 0, then we sign the first element of row and column is 0.
         * if this element is in first row or column,then we need change elements of the first line to 0.
         */
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    if(i==0) rowZero = true;
                    if(i==0) colZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        /**
         * if element of the first line is 0, then all elements in this row or column(not the first line) are 0
         */
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        /**
         * if the first row has 0, then do it.
         */
        if(rowZero){
            for(int j=0;j<col;j++){
                matrix[0][j] = 0;
            }
        }
        /**
         * if the first column has 0, then do it.
         */
        if(colZero){
            for(int i=0;i<row;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
