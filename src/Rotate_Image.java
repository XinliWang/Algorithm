/**
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class Rotate_Image {
    //方法一：使用额外space，主要是利用matrix[y][sizeX-x-1] = matrix[x][y]
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][]temp = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                temp[i][j] = matrix[i][j];
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[j][n-i-1] = temp[i][j];
            }
        }
    }

    //方法二：直接在matrix上修改，首先reverse每一行从左到右，然后reverse斜右对角每个数即得
    public void rotate2(int[][] matrix){
        int n = matrix.length;
        int temp=0;
        //reverse from left to right
        for (int i=0;i<n;i++){
            for (int j=0;j<n/2;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }

        //reverse left top to right bottom
        for (int i=0;i<n;i++){
            for (int j=0;j<n-i;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = temp;
            }
        }


    }
}




