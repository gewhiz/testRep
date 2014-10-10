//Sort a linked list using insertion sort.


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
    public ListNode insertionSortList(ListNode head) {
        // dummy node to link to the real head
        ListNode dummy = new ListNode(0);
        while (head != null) {
            // start from the dummy node
            ListNode curNode = dummy;

            // always compare with the next node to the current node,
            // so that a new node can be inserted in between
            while (curNode.next != null && head.val >= curNode.next.val) {
                curNode = curNode.next;
            }
            ListNode curNext = curNode.next;
            curNode.next = head;
            // must move the head to the next before updating the result list 
            head = head.next;
            curNode.next.next = curNext;
        } 

        return dummy.next;
    }

}
