/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startR = 0;
        int startC = 0;
        int endR = n-1;
        int endC = n-1;
        int count = 1;
        do{
            for(int i = startC;i <= endC;i++){
                matrix[startR][i] = count++;
            }
            for(int j = startR+1;j <= endR;j++){
                matrix[j][endC] = count++;
            }
            if(endR>startR){
                for(int i = endC-1;i>=startC;i--){
                    matrix[endR][i] = count++;
                }
            }
            if(endC>startC){
                for(int j = endR-1;j>=startR+1;j--){
                    matrix[j][startC] = count++;
                }
            }
            startR++;
            endR--;
            startC++;
            endC--;
        }while(endR>=startR && endC>=startC && count<=n*n);
        return matrix;
    }
}
