/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

 Example 1:
     11110
     11010
     11000
     00000
 Answer: 1

 Example 2:
     11000
     11000
     00100
     00011
 Answer: 3
 */
public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row==0) return 0;
        int col = grid[0].length;
        int count=0;
        //traverse every element
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='0') continue;
                count++;
                helper(grid,i,j,row,col);
            }
        }
        return count;
    }
    private void helper(char[][]grid,int i,int j,int row,int col){
        if(i<0 || j<0|| i>=row|| j>=col|| grid[i][j] == '0') return;
        /**traverse all elements which are adjacent 1(island),
         * make '1' to '0' so that we don't count it in the main function
        */
        grid[i][j] = '0';
        helper(grid,i-1,j,row,col);
        helper(grid,i+1,j,row,col);
        helper(grid,i,j-1,row,col);
        helper(grid,i,j+1,row,col);
    }
}
