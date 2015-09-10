/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which
 * minimizes the sum of all numbers along its path.

 Example
 Note
 You can only move either down or right at any point in time.

 Tags Expand
 Dynamic Programming
 */
public class Minimum_Path_Sum {
    public int minimumSum(int[][]grid){
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int [][]sum = new int[n][m];
        sum[0][0] = grid[0][0];
        for(int i=0;i<n;i++){
            sum[i][0] = sum[i-1][0]+grid[i][0];
        }
        for(int j=0;j<m;j++){
            sum[0][j] = sum[0][j-1]+grid[0][j];
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1]) + grid[i][j];
            }
        }
        return sum[n-1][m-1];
    }
}
