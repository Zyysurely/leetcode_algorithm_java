/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 后半部分反转，从外围开始比较
class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode first = head;
        ListNode last = head;
        while(last.next!=null && last.next.next!=null) {
            first = first.next;
            last = last.next.next;
        }
        first = reverse(first);
        while(first!=null && head != null) {
            // System.out.println(first.val);
            // System.out.println(head.val);
            if(first.val!=head.val) return false;
            first = first.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode mid) {
        ListNode pre = null;
        ListNode tmp = mid;
        while(mid.next != null) {
            tmp = mid.next;
            mid.next = pre;
            pre = mid;
            mid = tmp;
        }
        mid.next = pre;
        return mid;
    }
}