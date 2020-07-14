import java.util.*;
 
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 
class Solution_dep {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null) return head;
        HashMap<Integer, Boolean> map = new HashMap<>();
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        while(head != null) {
            if(map.containsKey(head.val)) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            map.put(head.val, true);
            head = head.next;
        }
        return res.next;
    }
}