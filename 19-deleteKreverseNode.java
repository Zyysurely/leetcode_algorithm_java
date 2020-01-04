
class ListNode {
     int val;
      ListNode next;
     ListNode(int x) { val = x; }
 }

 // 这也是一个双指针问题，比较常考虑的问题，并且需要主要当删除的元素为头元素的特殊情况！！！！！
class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode last = head;
        for(int i=0; i<n; i++) {
            last = last.next;
            if(last == null && i<n-1) return null;
        }
        ListNode pre = null;
        while(last!=null) {
            pre = first;
            first = first.next;
            last = last.next;
        }
        if(pre == null) return first.next;
        pre.next = first.next;
        return head;
    }
}