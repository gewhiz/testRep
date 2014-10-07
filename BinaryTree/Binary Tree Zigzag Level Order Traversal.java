//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        //Stack<TreeNode> st2 = new Stack<TreeNode>();
        if(root == null)
            return res;
        que.add(root);
        boolean flip = false;
        while(!que.isEmpty())
        {
            Queue<TreeNode> que2 = new LinkedList<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();
            while(!que.isEmpty())
            {
                TreeNode cur = que.remove();
                if(cur.left!=null)
                 {
                     que2.add(cur.left);
                 }
                 if(cur.right != null)
                 {
                     que2.add(cur.right);
                 }
                 list.add(cur.val);
            }
            if(flip){
                flip = false;
                List<Integer> list2 = new ArrayList<Integer>();
                for(int i = list.size()-1; i>=0; i--)
                {
                    list2.add(list.get(i));
                }
                res.add(list2);
            }
            else{
                flip = true;
                res.add(list);
            }
            que = que2;
        }
        return res;
    }
}
