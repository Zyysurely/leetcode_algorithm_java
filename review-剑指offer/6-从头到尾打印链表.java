class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution_offer_6 {
    public void reverseList(ListNode head) {
        if(head == null) return;
        reverseList(head.next);
        System.out.println(head.val);;
    }
}