class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution_offer_22 {
    public ListNode reverseKNode(ListNode head, int k) {
        ListNode kNode = head;
        while(k > 1 && head!=null) {
            head = head.next;
            k--;
        }
        if(k!=1) return null;
        while(head.next != null) {
            head = head.next;
            kNode = kNode.next;
        }
        return kNode;
    }
}