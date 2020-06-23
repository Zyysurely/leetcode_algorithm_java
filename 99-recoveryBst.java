/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_99 {
    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inOrder(root);
        if(t1!=null && t2!=null){
            int temp = t1.val;
            t1.val = t2.val;
            t2.val = temp;
        }
    }
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        if(pre!=null && root.val< pre.val) {
            if(t1 == null) t1=pre;
            t2 = root;
        }
        pre = root;
        inOrder(root.right);
    }
}         