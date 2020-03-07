
class ComplexListNode {
    int val;
    ComplexListNode next;
    ComplexListNode random;
    ComplexListNode(int x) {
        val = x;
    }
}

class Solution_offer_35 {
    public ComplexListNode clone(ComplexListNode head) {
        if(head == null) return null;
        ComplexListNode cur = head;
        while(cur!=null) {
            ComplexListNode copy = new ComplexListNode(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        while(cur != null) {
            if(cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        ComplexListNode cloneHead = head.next;
        while(cur.next != null) {
            ComplexListNode temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return cloneHead;
    }

}