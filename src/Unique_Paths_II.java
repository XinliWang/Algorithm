/**
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */

public class Unique_Paths_II {
    /**
     * DP:
     * 1. 1为障碍物，所以step[i][j] = 0 , ifA[i][j]==1;
     * 2. ifA[i][j]==0, step[i][j](T[j]) = step[i-1][j](T[j-1]) + step[i][j-1];
     * 3. 因为step[i][j-1]为上一轮循环的T[j] ,所以可以理解为T[j] = T[j] + T[j-1]
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int sizeRow = obstacleGrid.length;
        int sizeCol = obstacleGrid[0].length;
        int[] T = new int[sizeCol];
        T[0]=1;
        for (int i=0;i<sizeCol;i++){
            for (int j=0;j<sizeRow;j++){
                if (obstacleGrid[i][j]==1){
                    T[j] = 0;
                }else if(j>0){
                    T[j] = T[j] + T[j-1];
                }
            }
        }
        return T[sizeCol-1];
    }
}
