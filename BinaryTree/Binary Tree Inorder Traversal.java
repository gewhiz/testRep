//Given a binary tree, return the inorder traversal of its nodes' values.

//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,3,2].

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        if(root.left != null)
        {
            List<Integer> left = inorderTraversal(root.left);
            res.addAll(left);
        }
        res.add(root.val);
        if(root.right !=null)
        {
            res.addAll(inorderTraversal(root.right));
        }
        return res;
    }
}
