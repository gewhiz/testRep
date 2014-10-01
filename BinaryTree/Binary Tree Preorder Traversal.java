//Given a binary tree, return the preorder traversal of its nodes' values.

//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,2,3].

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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();

            stack.push(root);
            while (!stack.empty()) {
                TreeNode n = stack.pop();
                result.add(n.val);
                if (n.right != null) stack.push(n.right);
                if (n.left != null) stack.push(n.left);
            }
        }
        return result;
        
    }
}
