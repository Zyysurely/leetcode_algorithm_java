class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution_offer_25 {
    public ListNode mergeSortedList(ListNode head1, ListNode head2) {
        ListNode ne = new ListNode(0);
        ListNode res = ne;
        while(head1!=null && head2!=null) {
            if(head1.val < head2.val) {
                ne.next = head1;
                head1 = head1.next;
            } else { 
                ne.next = head2;
                head1 = head2.next;
            }
            ne = ne.next;   
        }
        if(head1 != null) ne.next = head1;
        else ne.next = head2;
        return res.next;
    }
}