//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

//How many possible unique paths are there?

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1)
            return 1;
        if(n == 1)
            return 1;
        int[][] map = new int[m][n];
        for(int i = 0; i< m ; i++)
        {
            map[i][0] = 1;
        }
        for(int i = 0; i<n; i++)
        {
            map[0][i] = 1;
        }
        
        for(int i =1; i<m;i++)
        {
            for(int j =1; j<n; j++)
            {
                int left = map[i][j-1];
                int up = map[i-1][j];
                map[i][j] = up+left;
            }
        }
        
        
        return map[m-1][n-1];
    }
}
