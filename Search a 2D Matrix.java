//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//For example,

//Consider the following matrix:

//[
  //[1,   3,  5,  7],
  //[10, 11, 16, 20],
  //[23, 30, 34, 50]
//]
//Given target = 3, return true.




public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int line = getLine(matrix, target);
        return getNum(matrix, target, line);
    }
    
    public int getLine(int[][] mat, int t)
    {
        int m = mat.length;
        int k = m;
        int i = 0;
        while(i<k)
        {
            if(i+1 == k)
        		break;
            int p = (k+i)/2;
            if(mat[p][0] > t)
            {
                k = p;
            }
            else if(mat[p][0] == t)
            {
                return p;
            }
            else
            {
                i = p;
            }
        }
        return i;
    }
    
    public boolean getNum(int[][] mat, int t, int l)
    {
        int n = mat[0].length;
        if(t<mat[l][0] || t> mat[l][n-1])
        {
            return false;
        }
        
        int i = 0;
        int j = n-1;
        while(i<j)
        {
            if(i+1 == j)
        	{
        		break;
        	}
            int p = (i+j)/2;
            if(mat[l][p] > t)
            {
                j=p;
            }
            else if(mat[l][p] == t)
            {return true;}
            else
            {
                i = p;
            }
        }
        if(mat[l][i] == t || mat[l][j] == t)
			return true;
        return false;
        
    }
}
