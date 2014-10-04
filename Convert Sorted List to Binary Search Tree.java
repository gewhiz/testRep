//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode pos = head;
        while(pos.next != null)
        {
            pos = pos.next;
        }
        return ToTree(head, pos);
    }
    
    public TreeNode ToTree(ListNode pre,  ListNode pos)
    {
        if(pre == pos)
        {
            TreeNode temp = new TreeNode(pre.val);
            return temp;
        }
        
        if(pre.next == pos)
        {
            TreeNode t = new TreeNode(pre.val);
            TreeNode n = new TreeNode(pos.val);
            n.left = t;
            return n;
        }
        
        if(pre.next.next== pos)
        {
            TreeNode t = new TreeNode(pre.val);
            TreeNode m = new TreeNode(pre.next.val);
            TreeNode n = new TreeNode(pos.val);
            m.left = t;
            m.right = n;
            return m;
        }
        
        int n = 0;
        ListNode k = pre;
        while(k.next != pos)
        {
            n++;
            k = k.next;
        }
        n/=2;
        ListNode mid = pre;
        while(n>0)
        {
            mid = mid.next;
            n--;
        }
        TreeNode midd = new TreeNode(mid.next.val);
        midd.left = ToTree(pre, mid);
        midd.right = ToTree(mid.next.next, pos);
        return midd;
    }
}
