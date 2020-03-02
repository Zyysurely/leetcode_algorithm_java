class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution_offer_24 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;   // 重要，不然会有环
        ListNode tail = reverseList(next);
        next.next = head;
        return tail;
    }
}