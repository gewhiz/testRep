/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> kk = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0)
            return kk;
        Arrays.sort(num);
        kk = rec(num, num.length-1);
        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        for(List<Integer> ll : kk)
        {
            hs.add(ll);
        }
        List<List<Integer>> jj = new ArrayList<List<Integer>>();
        for(List<Integer> mm : hs)
        {
            jj.add(mm);
        }
        return jj;
    }
    
    public List<List<Integer>> rec(int[] s, int k)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k ==0)
        {
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> empty = new ArrayList<Integer>();
            res.add(empty);
            list.add(s[0]);
            res.add(list);
            return res;
        }
        List<List<Integer>> pre = rec(s, k-1);
        
        int cur = s[k];
        for(int i = 0; i< pre.size(); i++)
        {
            List<Integer> ele = new ArrayList<Integer>(pre.get(i));
            ele.add(cur);
            res.add(ele);
        }
        res.addAll(pre);
        return res;
    }
}
