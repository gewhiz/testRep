//Reverse a linked list from position m to n. Do it in-place and in one-pass.

//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,

//return 1->4->3->2->5->NULL.

//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode target = head;
        while(target.next != null && n>1)
        {
            target = target.next;
            n--;
        }
        ListNode nex = target.next;
        ListNode pre = dummy;
        ListNode beg = head;
        while(m>1)
        {
            pre = pre.next;
            beg = beg.next;
            m--;
        }
        ListNode mm =reverseLinkedList(beg, target);
        pre.next = mm;
        if(beg != null)
            beg.next = nex;
        return dummy.next;
    }
    
    public ListNode reverseLinkedList(ListNode head, ListNode target)
    {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null)
        {
            if(cur == target)
            {
                cur.next = pre;
                break;
            }
            ListNode nex = cur.next;
            cur.next= pre;
            pre = cur;
            cur = nex;
        }
        if(cur == null)
            return pre;
        return cur;
    }
}
