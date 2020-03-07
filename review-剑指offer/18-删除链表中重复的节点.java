class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution_offer_18 {
    public ListNode deleteDupliNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        if(head.val == next.val) {
            while(next != null && head.val == next.val) next=next.next;
            return deleteDupliNode(next);
        } else {
            head.next = deleteDupliNode(head.next);
        }
        return head;
    }
}