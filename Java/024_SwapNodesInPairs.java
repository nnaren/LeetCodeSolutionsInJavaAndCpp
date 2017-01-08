/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        p1.next = p2.next;
        p2.next = p1;
        p1.next = swapPairs(p1.next);
        return p2;
    }
}
