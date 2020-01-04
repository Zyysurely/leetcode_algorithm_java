/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==0) return head;
        ListNode pre = null;
        int count = 0, cur = 0;
        ListNode check = head, res = head, next = null;
        while(cur < k && check != null) {
            check = check.next;
            cur ++;
        }
        if(cur == k) {
            while(count < k && res != null) {
                next = res.next;
                res.next = pre;
                pre = res;
                res = next;
                count ++;
            }
            if(next != null) {
                head.next = reverseKGroup(next, k);
            }
            return pre;
        } else {
            // 不够k
            return head;
        }
    }
}