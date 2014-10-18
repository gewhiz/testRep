//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int cur = head.val;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode pos = head.next;
        while(pos != null)
        {
            int val = pos.val;
            if(val == cur)
            {
                pre.next = pos.next;
                pos.next = null;
                pos = pre.next;
            }
            else
            {
                if(pre.next != pos)
                {
                    pre = pre.next;
                }
                cur = val;
                pos = pos.next;
            }
            
        }
        return dummy.next;
    }
}
