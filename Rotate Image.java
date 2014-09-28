//You are given an n x n 2D matrix representing an image.

//Rotate the image by 90 degrees (clockwise).

//Follow up:
//Could you do this in-place?

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n; i++)
        {
            for(int j = i; j<n; j++)
            {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j < n/2; j++)
            {
                int m  = n - j - 1;
                int temp = matrix[i][m];
                matrix[i][m] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
