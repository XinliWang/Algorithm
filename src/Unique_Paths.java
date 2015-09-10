/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?


 Above is a 3 x 7 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.
 */



public class Unique_Paths {
    //方法一：DP
    public int uniquePaths(int m, int n) {
        int[][] D = new int[m][n];
        for(int i=0;i < m;i++){
            D[i][0] = 1;
        }
        for(int j=0;j < n;j++){
            D[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                D[i][j] = D[i][j-1] + D[i-1][j];
            }
        }
        return D[m-1][n-1];
    }

    //方法二：Mathmatical
    public int uniquePaths2(int m,int n){
        if(m==1 || n==1){
            return 1;
        }
        long num = 1;
        m--;
        n--;
        for (int i=1;i<=n;i++){
            num = num * (i+m)/i;
        }
        return (int)num;
    }

    public static void main(String[] args){
        Unique_Paths u = new Unique_Paths();
        int i = u.uniquePaths2(3,7);
        System.out.print(i);
    }
}
