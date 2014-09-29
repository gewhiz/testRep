//Suppose a sorted array is rotated at some pivot unknown to you beforehand.

//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

//You are given a target value to search. If found in the array return its index, otherwise return -1.

//You may assume no duplicate exists in the array.

public class Solution {
    public int search(int[] A, int target) {
         return bisearch(A, 0, A.length-1, target);
    }
    
    public int bisearch(int[] A, int pre, int pos, int t)
    {
         if(pre == pos)
       {
           if(A[pre] == t)
               return pre;
           else
               return -1;
       }
       int p = (pre + pos)/2;
       if(A[p] == t)
           return p;
       if(p == pre)
       {
    	   if(A[pos] == t)
    	   {
    		   return pos;
    	   }
    	   else
    	   {
    		   return -1;
    	   }
       }
       if(A[pre] < A[pos])
       {
           if(A[pre] >t || A[pos] <t)
               return -1;
           if(A[p] < t)
           {
               return bisearch(A, p, pos, t);
           }
           else 
           {
               return bisearch(A, pre, p, t);
           }
       }

       if(A[p] > A[pre])
       {
           if(A[p] >t && A[pre] <= t)
           {
               return bisearch(A, pre, p, t);
           }
           else
           {
               return bisearch(A, p, pos, t);
           }
       }
       else
       {
           if(A[p] < t && A[pos]>= t)
           {
               return bisearch(A, p, pos, t);
           }
           else
           {
               return bisearch(A, pre, p, t);
           }
       }
    }
}
