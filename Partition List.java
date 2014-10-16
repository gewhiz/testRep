//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

//You should preserve the original relative order of the nodes in each of the two partitions.

//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(p!= null && p.val < x)
        {
            pre = pre.next;
            p = p.next;
        }
        if(p==null)
            return head;
        while(p.next != null)
        {
            if(p.next.val >= x)
                p = p.next;
            else
            {
                ListNode temp = p.next;
                p.next = temp.next;
                
                ListNode nex = pre.next;
                pre.next = temp;
                temp.next = nex;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
