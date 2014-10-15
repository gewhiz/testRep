//Given preorder and inorder traversal of a tree, construct the binary tree.

//Note:
//You may assume that duplicates do not exist in the tree.


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len == 0 || len!= inorder.length) 
            return null;
        if(len == 1)
            return new TreeNode(preorder[0]);
        return build(inorder,0, len-1,  preorder, 0, len-1);
    }
    
    public TreeNode build(int[] inorder, int inStart, int inEnd, 
                            int[] preorder, int preStart, int preEnd){
        if(inStart > inEnd || preStart > preEnd)
            return null;
 
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
 
        int k=0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                k = i;
                break;
            }
        }
 
        root.left = build(inorder, inStart, k-1, preorder, preStart+1, preStart+k-inStart);
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.right = build(inorder, k+1, inEnd, preorder, preStart+k+1-inStart, preEnd);
        // postStart+k-inStart = postStart+k-(inStart+1) +1
 
        return root;
    }
}
