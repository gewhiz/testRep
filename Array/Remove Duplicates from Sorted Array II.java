//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?

//For example,
//Given sorted array A = [1,1,1,2,2,3],

//Your function should return length = 5, and A is now [1,1,2,2,3].


public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length <3)
        	return A.length;
        int len = 2, pos = 2;
        while (pos < A.length) {
            if (A[pos] > A[len-2])
            {
                A[len] = A[pos];
                len++;
            }
            pos++;
        }
        return len;
    }
}
