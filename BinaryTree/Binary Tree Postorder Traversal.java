//Given a binary tree, return the postorder traversal of its nodes' values.

//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [3,2,1].

//Note: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<TreeNode> out = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode top = st.pop();
            out.push(top);
            if(top.left!= null)
                st.push(top.left);
            if(top.right!=null)
                st.push(top.right);
            
        }
        while(!out.isEmpty())
        {
            res.add(out.pop().val);
        }
        return res;
    }
}
