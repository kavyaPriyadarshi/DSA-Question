/*
Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
*/
class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]<0)
                {
                    count++;
                }
            }
        }
        return count;
    }


   // 2nd Approach

    class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0; 
        int col = grid[0].length-1;
        int count = 0;
        while(row < rows && col >= 0){
            if(grid[row][col] >= 0){
                row++;
            } else {
                count += rows-row;
                col--;
            }
        }
        return count;
    }
}
}
