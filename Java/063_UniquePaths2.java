public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        //flip upper left cell (the start cell): 1 => 0 or 0 => 1
        obstacleGrid[0][0] ^= 1;
        
        //first row: if 1, then 0; otherwise, left cell
        for(int i = 1; i < n; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
        
        //first column: if 1, then 0; otherwise, top cell
        for(int i = 1; i < m; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
            
        //rest: if 1, then 0; otherwise, left cell + top cell
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                
        //return lower right cell (the end cell)
        return obstacleGrid[m - 1][n - 1];
    }
}
