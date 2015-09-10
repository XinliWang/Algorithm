import java.util.ArrayList;
import java.util.List;

/**
 *Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int endR = matrix.length-1;
        if(endR+1==0) return list;
        int endC = matrix[0].length-1;
        int startR = 0;
        int startC = 0;
        do {
            for (int i=startC;i<=endC;i++){
                list.add(matrix[startR][i]);
            }
            for (int j = startR+1;j<=endR;j++){
                list.add(matrix[j][endC]);
            }
            if (endR > startR){
                for (int i=endC-1;i>=startC;i--){
                    list.add(matrix[endR][i]);
                }
            }
            if (endC > startC){
                for (int j = endR-1;j>=startR+1;j--){
                    list.add(matrix[j][startC]);
                }
            }
            startC++;
            endC--;
            startR++;
            endR--;
        }while(endC>=startC && endR>=startR);
        return list;
    }
}
