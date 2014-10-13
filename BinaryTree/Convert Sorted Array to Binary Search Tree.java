//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0)
            return null;
        if(num.length == 1)
            return new TreeNode(num[0]);
            
        return tobst(num, 0, num.length-1);
    }
    
    public TreeNode tobst(int[] num, int pre, int pos)
    {
        if(pre == pos)
        {
            return new TreeNode(num[pre]);
        }
        int mid = (pre+pos)/2;
        if(mid == pre)
        {
            TreeNode par = new TreeNode(num[pos]);
            TreeNode chil = new TreeNode(num[pre]);
            par.left = chil;
            return par;
        }
        TreeNode par = new TreeNode(num[mid]);
        par.left = tobst(num, pre, mid-1);
        par.right = tobst(num, mid+1, pos);
        return par;
    }
}
