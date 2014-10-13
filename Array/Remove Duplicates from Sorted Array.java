//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

//Do not allocate extra space for another array, you must do this in place with constant memory.

//For example,
//Given input array A = [1,1,2],

//Your function should return length = 2, and A is now [1,2].

public class Solution {
    public int removeDuplicates(int[] A) {
        int pos = 1;
        int pre = 0;
        if(A == null || A.length == 0)
        return 0;
        
        while(pos < A.length)
         {
             if(A[pre] >= A[pre+1])
             {
            	 int t = 1;
                 while(A[pre+t] <= A[pre])
                 {
                	 t++;
                	 if(pre+t == A.length)
                		 return pre +1;
                 }
                 
                 pos = pre+t;
                 pre++;
                 int temp = A[pos];
                 A[pos] = A[pre];
                 A[pre] = temp;
                 
             }
             else if(A[pre] < A[pre+1])
             {
            	 pre++;
            	 if(pos<= pre)
            	 {
            		 pos = pre+1;
            	 }
             }

             
             
         }
         return pre+1;


    }
}
