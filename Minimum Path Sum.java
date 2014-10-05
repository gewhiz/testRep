//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

//Note: You can only move either down or right at any point in time.


public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n == 0)
            return 0;
        if(m == 1 && n == 1)
            return grid[0][0];
        
        int[][] map = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++)
        {
            map[i][0] = -1;
        }
        for(int i = 0; i<n+1; i++)
        {
            map[0][i] = -1;
        }
        for(int i = 1; i< (m+1); i++)
        {
            for(int j = 1; j<(n+1); j++)
            {
                int cur = grid[i-1][j-1];
                int up = map[i][j-1];
                int left = map[i-1][j];
                if(up < 0 && left < 0)
                {
                    map[i][j] = cur;
                }
                else
                {
                    if(up<0)
                    {
                        map[i][j] = left + cur;
                    }
                    else if(left < 0)
                    {
                        map[i][j] = up + cur;
                    }
                    else
                    {
                        map[i][j] = cur;
                        map[i][j] += up>left? left:up;
                    }
                }
            }
        }
        return map[m][n];
    }
}
