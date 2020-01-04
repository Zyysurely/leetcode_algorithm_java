/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }
    // 类似于合并排序链表的概念，是一个merge的递归
    public TreeNode merge(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) return null;
        if(t2==null) return t1;
        if(t1==null) return t2;
        TreeNode cur = new TreeNode(t1.val+t2.val);
        cur.left = merge(t1.left, t2.left);
        cur.right = merge(t1.right, t2.right);
        return cur;
    }
}