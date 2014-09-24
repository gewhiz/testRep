//Minimum Depth of Binary Tree 

//******pay attention to the define of leaf node.....

//Given a binary tree, find its minimum depth.

//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return 1+ minDepth(root.right);
        if(root.right == null)
            return 1+minDepth(root.left);
        int l = 1+ minDepth(root.left);
        int r = 1+minDepth(root.right);
        return l>r?r:l;
    }
}
