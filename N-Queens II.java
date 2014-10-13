public class Solution {
    
    int res = 0;
    public int totalNQueens(int n) {
        int[][] b = new int[n][n];
        dfs(b, 0, n);
        
        return res;
    }
    
    public void dfs(int[][] b, int col, int n)
    {
        if (col == n)
        {
            res++;
            return;
        }
        for (int row = 0; row < n; row ++)
        {
            if (isSafe(b, row, col, n))
            {
                b[row][col] = 1;
                dfs(b, col + 1, n);
                b[row][col] = 0;
            }
        }
    }
    
    public boolean isSafe (int[][]matrix, int row,int column, int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i==row && matrix[i][j]==1) return false;
            if(j==column&& matrix[i][j]==1) return false;
            if((Math.abs(row-i)==Math.abs(column-j))&&(matrix[i][j]==1)) return false;
        }
    }
    return true;
    }
}
