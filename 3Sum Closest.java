/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/


public class Solution {
    
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int len = num.length;
        if(len<3)
            return Integer.MAX_VALUE;
        int k = target;
        int res = num[0]+num[1]+num[2];
        for(int i = 0; i<len; i++)
        {
            int m = 0;
            int n = len-1;
            while(m<n)
            {
                if(m == i)
                {
                    m++;
                    continue;
                }
                if(n == i)
                {
                    n--;
                    continue;
                }
                int sum = num[i]+num[m]+num[n];
                if(sum == k)
                    return k;
                if(Math.abs(k-sum) < Math.abs(k-res)){
                    res = sum;
                }
                if(sum>k)
                    n--;
                else
                    m++;
            }
        }
        return res;
    }
}
