/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode res = head, evenHead=head.next;
        ListNode odd = res, even = evenHead;
        // 分为奇偶两个链表进行🔗
        while(even!=null && even.next!=null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return res;
    }
}