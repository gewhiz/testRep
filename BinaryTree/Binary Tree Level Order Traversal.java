//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
// [9,20],
//  [15,7]
//]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return res;
    }
}
