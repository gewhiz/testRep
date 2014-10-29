/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        int len = num.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(len<3)
            return res;
        Arrays.sort(num);

        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        for(int k = 0; k<len;k++)
        {
            int i = 0;
            int j = len-1;
            while(i<j && i<k && j>k)
            {
                int sum = num[i]+num[j]+num[k];
                if(sum == 0)
                {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[k]);
                    list.add(num[j]);
                    hs.add(list);
                    i++;
                    j--;
                }
                else if(sum > 0)
                {
                    j--;
                }
                else
                {
                    i++;
                }
            }
        }
        for(List<Integer> list : hs)
            res.add(list);
        return res;
    }

}
