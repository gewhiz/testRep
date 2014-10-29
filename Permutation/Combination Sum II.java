/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    HashSet<List<Integer>> hs; 
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = num.length;
        if(len == 0)
            return res;
        Arrays.sort(num);
        hs = new HashSet<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        recurse(list, target, num, 0);
        for(List<Integer> ele : hs)
        {
            res.add(ele);
        }
        return res;
    }
    
    
    private void recurse(List<Integer> list, int target, int[] candidates, int index) {
    if (target == 0) {
        hs.add(list);
        return;
    }
    
    for (int i = index; i < candidates.length; i++) {
        int newTarget = target - candidates[i];
        if (newTarget >= 0) {
            List<Integer> copy = new ArrayList<Integer>(list);
            copy.add(candidates[i]);
            recurse(copy, newTarget, candidates, i+1);
        }
    }
} 
}
