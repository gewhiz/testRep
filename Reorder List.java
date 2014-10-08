//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

//You must do this in-place without altering the nodes' values.

//For example,
//Given {1,2,3,4}, reorder it to {1,4,2,3}.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        int len = 1;
        if(head == null || head.next == null)
            return;
        ListNode k = head;
        while(k.next != null)
        {
            k = k.next;
            len++;
        }
        k = head;
        int h = len/2;
        int i = 0;
        while(i<h)
        {
            i++;
            k = k.next;
        }
        ListNode d = reverseLinkedList(k);
        while(head.next != null && d.next != null)
        {
            ListNode t = d.next;
            ListNode nex = head.next;
            head.next = d;
            d.next = nex;
            head = nex;
            d = t;
        }
    }
    
    public ListNode reverseLinkedList(ListNode head)
    {
        ListNode pre = null;
        ListNode cur = head;
        ListNode pos = head.next;
        while(cur !=null)
        {
            pos = cur.next;
            cur.next= pre;
            pre = cur;
            cur = pos;
        }
        return pre;
    }
}
