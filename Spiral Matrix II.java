//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

//For example,
//Given n = 3,

//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n <= 0)
        {
            return res;
        }
        
        if(n==1)
        {
            res[0][0] = 1;
            return res;
        }
        int x0 = 0;
        int x1 = n-1;
        
        int p = 1;
        while(x0<=x1)
        {
            if(x0 == x1)
        	{
        		res[x0][x1] = n*n;
        		return res;
        	}
            for(int i = x0;i<x1; i++)
            {
                res[x0][i] = p;
                p++;
            }
            for(int i = x0; i<x1; i++)
            {
                res[i][x1] = p;
                p++;
            }
            for(int i = x1; i>x0; i--)
            {
                res[x1][i] = p;
                p++;
            }
            for(int i = x1; i>x0; i--)
            {
                res[i][x0] = p;
                p++;
            }
            
            x0++;
            x1--;
        }
        return res;
    }
}
