/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_23 {
    // n的时间复杂度内合并两个列表，两两合并，一共是logk
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0) return null;
        return recurMerge(lists, 0, len-1);
    }

    // 以建立树的方法来思考递归过程，以及返回过程
    public ListNode recurMerge(ListNode[] lists, int l, int r) {
        if(l < r) {
            int mid = (l+r)/2;
            ListNode left = recurMerge(lists, l, mid);
            ListNode right = recurMerge(lists, mid+1, r);
            return merge(left, right);
        }
        return lists[l];
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(l != null && r!= null) {
            if(l.val <= r.val) {
                res.next = l;
                l = l.next;
            } else {
                res.next = r;
                r = r.next; 
            }
            res = res.next;
        }
        if(l != null) {res.next = l;}
        else if(r != null) {res.next = r;}
        else {res.next = null;}
        return temp.next;
    }
}