class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
class Solution_offer_52 {
    public ListNode commonNode(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) return null;
        ListNode phead1 = head1, phead2 = head2;
        while(head1 != head2) {
            if(head1 == null) head1 = phead2; else head1 = head1.next;
            if(head2 == null) head2 = phead1; else head2 = head2.next;
        }
        return head1;
    }

}