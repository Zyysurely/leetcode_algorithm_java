/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode res = head.next;
        head.next = swapPairs(res.next);
        res.next = head;
        return res;
    }
}