/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        int k = sum;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null)
        {
            if(root.val == k){
                List<Integer> list = new ArrayList<Integer>();
                list.add(k);
                res.add(list);
            }
            return res;
        }
        int diff = k - root.val;
        List<List<Integer>> left = pathSum(root.left, diff);
        left.addAll(pathSum(root.right, diff));
        for(List<Integer> ele : left)
        {
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            list.addAll(ele);
            res.add(list);
        }
        return res;
    }
}
