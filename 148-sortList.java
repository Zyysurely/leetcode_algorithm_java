/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
         int val;
         ListNode next;
        ListNode(int x) { val = x; }
     }
class Solution_148 {
    // 归并排序
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head) {
        if(head.next == null) return head;
        ListNode fast = head, slow = head, pre=null;
        // 链表找中点的方式
        while(fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l, r);
    }
    // 合并，注意多出来的那段
    public ListNode merge(ListNode l, ListNode r) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while(l != null && r != null) {
            if(l.val <= r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if(l!=null) {
            cur.next = l;
        }
        if(r!=null){
            cur.next = r;
        }
        return newHead.next;
    }
}