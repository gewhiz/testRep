/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] num) {
        int len = num.length;
        if(len == 1)
            return num[0];
        int pre = 0;
        int pos = len-1;
        return find(num, pre, pos);
    }
    
    public int find(int[] n, int pre, int pos)
    {
        if(pre == pos)
            return n[pre];
        int mid = (pre+pos)/2;
        if(pre == mid)
        {
            return n[pre]<n[pos]? n[pre]:n[pos];
        }
        if(n[mid]>n[mid+1])
            return n[mid+1];
        
        if(n[mid]>n[pre])
        {
            int local = find(n, mid, pos);
            return local<n[0]?local:n[0];
        }
        else
        {
            return find(n, pre, mid);
        }
    }
}
