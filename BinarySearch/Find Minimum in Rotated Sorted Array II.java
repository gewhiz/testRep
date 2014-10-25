/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

public class Solution {
    public int findMin(int[] num) {
        int len = num.length;
        if(len ==0)
            return 0;
        if(len ==1)
            return num[0];
        int s = num[0];
        int e = num[len-1];
        if(e>s)
            return s;
        int pre = 0;
        int pos = len-1;
        while(true)
        {
            int mid = (pre+pos)/2;
            if(pre+1>=pos)
            {
                return num[pre] < num[pos]?num[pre]:num[pos];
            }
            
            int k = num[mid];
            int t = mid-1;
            while(t>=pre)
            {
                if(num[t] == k)
                    t--;
                else if(num[t] > k)
                    return k;
                else
                {
                    if(num[t]>=s)
                        pre = mid;
                    else
                        pos = mid;
                    break;
                }
            }
            if(t < pre)
            {
                pre = mid;
            }
        }
    }
}
