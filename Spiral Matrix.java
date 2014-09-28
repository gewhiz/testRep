//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

//For example,
//Given the following matrix:

//[
 //[ 1, 2, 3 ],
 //[ 4, 5, 6 ],
 //[ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         if(matrix == null)
            return null;
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0)
        {
            return res;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int lim = m>n?n:m;
        if(m == n && n == 1)
        {
        	res.add(matrix[0][0]);
        	return res;
        }
        int i = 0;

        while((i<m-i) && (i<n-i))
        {
            res.addAll(getCircle(matrix, i, m, n));
            i++;
        }
        return res;
    }
    
    public List<Integer> getCircle(int[][] matrix, int idx, int m, int n)
    {
       int hrow = m - idx -1;
        int hcol = n - idx -1;
        List<Integer> res = new ArrayList<Integer>(); 

        if(idx == hrow && idx ==hcol)
        {
        	res.add(matrix[hrow][hcol]);
        	return res;
        }
        for(int i = idx; i< hcol; i++)
        {
            res.add(matrix[idx][i]);
        }
        for(int i = idx; i < hrow ; i++)
        {
            res.add(matrix[i][hcol]);
        }
        

        if(hrow == idx)
        {
        	res.add(matrix[hrow][hcol]);
        }
        else
        {
        for(int i = hcol; i >idx; i--)
        {
            res.add(matrix[hrow][i]);
        }
        }
        
        if(hcol == idx)
        {
        	res.add(matrix[hrow][hcol]);
        }
        else
        {

        for(int i = hrow; i> idx; i--)
        {
            res.add(matrix[i][idx]);
        }
        }
        return res;
    }
}
