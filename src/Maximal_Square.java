/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing all 1's and return its area.
   For example, given the following matrix:
   1 0 1 0 0
   1 0 1 1 1
   1 1 1 1 1
   1 0 0 1 0

   Return 4.
 */
public class Maximal_Square {
    public int maximalSquare(char[][] matrix){
        int row = matrix.length;
        if(row==0||matrix==null){
            return 0;
        }
        int col = matrix[0].length;
        int[][] count = new int[row][col];
        int maxSquare =0;

        //第一行初始化，元素为0，值为0，元素为1，值为1
        for(int i=0;i<row;i++){
            count[i][0] = matrix[i][0]-'0';
            if(matrix[i][0]=='1'){
                maxSquare=1;
            }
        }
        //第一列初始化，元素为0，值为0，元素为1，值为1
        for(int j=0;j<col;j++){
            count[0][j] = matrix[0][j]-'0';
            if(matrix[0][j]=='1'){
                maxSquare=1;
            }
        }
        //元素为0，值为0. 否则查看周围三个元素，若都相同则+1，否则取最小的+1.
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]=='0'){
                    count[i][j] =0;
                }else{
                    count[i][j] = Math.min(matrix[i][j-1],Math.min(matrix[i-1][j-1],matrix[i-1][j])) + 1;
                    maxSquare = Math.max(maxSquare,count[i][j]);
                }
            }
        }
        return maxSquare*maxSquare;
    }
}
