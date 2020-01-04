/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {    
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null||headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            if(pA == null){
                pA = headB;
            } else {
                pA = pA.next;
            }
            
            if(pB == null){
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}