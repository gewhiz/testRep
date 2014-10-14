//Given a binary tree, flatten it to a linked list in-place.

//For example,
//Given

//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6

//Hints:
//If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

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
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode pre = root;
        if(pre.right != null)
            st.push(pre.right);
        if(pre.left !=null)
            st.push(pre.left);
        
        while(!st.isEmpty())
        {
            TreeNode temp = st.pop();
            pre.right = temp;
            pre.left = null;
            pre = temp;
            
            if(temp.right != null)
            {
                st.push(temp.right);
            }
            if(temp.left != null)
            {
                st.push(temp.left);
            }

        }
    }
}
