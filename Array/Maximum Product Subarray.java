//Find the contiguous subarray within an array (containing at least one number) which has the largest product.

//For example, given the array [2,3,-2,4],
//the contiguous subarray [2,3] has the largest product = 6.

public class Solution {
    public int maxProduct(int[] A) {
        if (A.length == 1)
        {
            return A[0];
        }
        
        int[] prod = new int[A.length];
        prod[0] = A[0];
        int localmin = A[0];
        int localmax = A[0];
        int totalmax = localmax;
        for (int i = 1; i < A.length; i++) {
            int temp = localmax;
            localmax = max(A[i], max(A[i]*localmax, A[i]*localmin));
            localmin = min(A[i], min(A[i]*temp, A[i]*localmin));
            totalmax = max(localmax, totalmax);
		}
		
		return totalmax;
 
    }
    
    public int max(int a, int b)
    {
        return a>b? a:b;
    }
    
    public int min(int a, int b)
    {
        return a>b?b:a;
    }
}
