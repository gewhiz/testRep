//Given a sorted array of integers, find the starting and ending position of a given target value.

//Your algorithm's runtime complexity must be in the order of O(log n).

//If the target is not found in the array, return [-1, -1].

//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int len = A.length;
        int left = findLeft(A, target, 0, len-1);
        int right = findRight(A, target, 0, len-1);
        res[0] = left;
        res[1] = right;
        return res;
    }
    
    int findRight(int[] A, int t, int pre, int pos)
    {
        int mid = (pre+pos)/2;
        if(pre == mid)
        {
            if(A[pos] == t)
            	return pos;
            if(A[pre] == t)
                return pre;
            return -1;
        }
        if(A[mid]<t)
        {
            return findRight(A, t, mid, pos);
        }
        else if(A[mid] == t)
        {
        	if(mid+1 < A.length && A[mid+1] == t)
        		return findRight(A,t, mid+1, pos);
        	else
        		return mid;
        }
        else
        {
            return findRight(A, t, pre, mid);
        }
    }
    
    int findLeft(int[] A, int t, int pre, int pos)
    {
        int mid = (pre+pos)/2;
        if(pre == mid)
        {
            if(A[pre] == t)
                return pre;
            if(A[pos] == t)
            	return pos;
            return -1;
        }
        if(A[mid]<t)
        {
            return findLeft(A, t, mid, pos);
        }
        else if(A[mid] == t)
        {
        	if(mid-1 >=0 && A[mid-1] == t)
        		return findLeft(A,t, pre, mid-1);
        	else
        		return mid;
        }
        else
        {
            return findLeft(A, t, pre, mid);
        }
    }
}
