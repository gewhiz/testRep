//Follow up for problem "Populating Next Right Pointers in Each Node".

//What if the given tree could be any binary tree? Would your previous solution still work?

//Note:

//You may only use constant extra space.
//For example,
//Given the following binary tree,
//         1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \    \
//    4-> 5 -> 7 -> NULL


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> cq = new LinkedList<TreeLinkNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeLinkNode conn = q.remove();
            conn.next = null;
            if(conn.right != null)
            {
                cq.add(conn.right);
            }
            if(conn.left != null)
                cq.add(conn.left);
            
            while(true)
            {
                if(q.isEmpty())
                {
                    break;
                }
                TreeLinkNode temp = q.remove();
                if(temp == null)
                    continue;
                if(temp.right != null){
                    cq.add(temp.right);
                }
                if(temp.left!=null)
                {
                    cq.add(temp.left);
                }

                temp.next = conn;
                conn = temp;
            }
            q = cq;
            cq = new LinkedList();
        }
    }
}
