import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.

 Example
 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

 Tags Expand
 Dynamic Programming
 */
public class Triangle {
    //Solution1:Bottom to up
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
        if (triangle == null || triangle.size() == 0){
            return 0;
        }

        int n = triangle.size();
        int [][] sum = new int[n][n];

        for(int i =0;i<n;i++){
            sum[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                sum[i][j] = Math.min(sum[i+1][j],sum[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return sum[0][0];
    }
    //Solution2:up to bottom
    public int minimumTotal2(List<List<Integer>> triangle) {
        int sizeRow = triangle.size();
        int sizeCol = triangle.get(0).size();
        int[][]T = new int[sizeRow][sizeCol];
        T[0][0] = triangle.get(0).get(0);
        for (int i=1;i<sizeRow;i++){
            for(int j=0;j<i+1;j++){
                //边界情况boundary condition
                if(j==0){
                    T[i][j] = T[i-1][j] + triangle.get(i).get(j);
                }else if(j==i){
                    T[i][j] = T[i-1][j-1] + triangle.get(i).get(j);
                }else{
                    T[i][j] = Math.min(T[i-1][j-1],T[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = T[sizeRow-1][0];
        for(int i=1;i<sizeCol;i++){
            min = Math.min(min,T[sizeRow][i]);
        }
        return min;
    }

}
