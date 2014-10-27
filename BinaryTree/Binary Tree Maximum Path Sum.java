/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    int maxsum;
    
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;

            maxsum = root.val;
            recNodes(root); 
            return maxsum;
    }
    
    public int recNodes(TreeNode node)
        {
            int numl=0,numr=0;
            if (node.left!=null)
                numl = recNodes(node.left);
            if (node.right !=null)
                numr = recNodes(node.right);

            //choose the max path, either left or right 
            int value = node.val;
            int sumWhole = checkMax(value,numl+numr);
            int sumLeft = numl>0?checkMax(value,numl):value;
            int sumRight = numr>0?checkMax(value,numr):value;

            return max(sumLeft,sumRight);
        }
        
        public int max(int a, int b)
        {
            return a>b?a:b;
        }
        
        int checkMax(int value, int sum)
        {
            if(sum>0)
                sum+=value;
            else
                sum=value;
            if(sum>maxsum)
                maxsum = sum;
            return sum;
        }
}
