/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || (m==n)) return head;
        ListNode res = head;
        ListNode pre = null;
        ListNode cur;
        ListNode first = head;
        ListNode last = head;
        int index = 1;
        while(head!=null){
            if(index == m) {
                first = pre;
                last = head;
                pre = head;
                head = head.next;
            } else if(index > m && index <= n){
                cur = head.next;
                head.next = pre;
                pre = head;
                head = cur;
            } else {
                pre = head;
                head = head.next;
            }
            
            if (index == n)
                 break;
            index ++;
        }
        last.next = head;
        if(m == 1){
            return pre;
        } else {
            first.next = pre;
            return res;
        }
    }
}


class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}