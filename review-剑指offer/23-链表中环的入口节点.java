class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


class Solution_offer_23 {
    public ListNode circleEntryNode(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode first = head.next;
        ListNode last = head.next.next;
        while(first != last) {
            first = first.next;
            last = last.next.next;
        }
        while(head!=first) {
            head = head.next;
            first = first.next;
        }
        return head;
    }
}