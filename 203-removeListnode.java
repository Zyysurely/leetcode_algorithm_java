/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode res = head;
        while(res!=null && res.val==val) {
            res = res.next;
        }
        head = res;
        while(head!=null) {
            if(head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return res;
    }
}