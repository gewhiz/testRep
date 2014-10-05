/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]


public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        Queue<TreeNode> back = new LinkedList<TreeNode>();
        while(!que.isEmpty())
        {
            List<Integer> list = new ArrayList<Integer>();
            while(!que.isEmpty())
            {
                TreeNode tn = que.remove();
                if(tn.left!=null)
                    back.add(tn.left);
                if(tn.right!= null)
                    back.add(tn.right);
                list.add(tn.val);
            }
            res.add(list);
            while(!back.isEmpty())
            {
                que.add(back.remove());
            }
        }
        List<List<Integer>> rev = new ArrayList<List<Integer>>();
        int j = res.size()-1;
	    while (j >=0) {
		    rev.add(res.get(j));
		    j--;
	    }
	    return rev;
    }
}
