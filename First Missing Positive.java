//Given an unsorted integer array, find the first missing positive integer.

//For example,
//Given [1,2,0] return 3,
//and [3,4,-1,1] return 2.

//Your algorithm should run in O(n) time and uses constant space.

public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length;
	        for(int i = 0; i< len; i++)
	        {
	            int k = A[i];
	            while(k>0 && k<= len && A[k-1] != k )
	            {
	                int temp = A[k-1];
	                A[k-1] = A[i];
	                A[i] = temp;
	                k = A[i];
	            }
	        }
        
        for(int i = 0; i<len; i++)
        {
            if(A[i] != i+1)
            {
                return i+1;
            }
        }
        return len+1;
    }
}
