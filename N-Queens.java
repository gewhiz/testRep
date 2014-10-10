//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//Given an integer n, return all distinct solutions to the n-queens puzzle.

//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

//For example,
//There exist two distinct solutions to the 4-queens puzzle:
/*
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/



public class Solution {
    List<String[]> res = new ArrayList<String[]>();
    public List<String[]> solveNQueens(int n) {
        
        int[][] b = new int[n][n];
        dfs(b, 0, n);
        
        return res;
    }
    
    
    public void dfs(int[][] b, int col, int n)
    {
        if (col == n)
        {
            String[] temp = convertMat(b);
            res.add(temp);
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
    
    public String[] convertMat(int[][] mat)
    {
        String[] res = new String[mat.length];
        for(int i = 0; i<mat.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<mat.length; j++)
            {
               if(mat[i][j] == 1)
                   sb.append("Q");
               else
                   sb.append(".");
            }
            res[i] = sb.toString();
        }
        return res;
    }
}
