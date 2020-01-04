/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return res;
    }
    //中序遍历
    
    public void getMin(TreeNode root) {
        if(root == null)  return;
        getMin(root.left);
        if(pre!=null) {
            res = Math.min(res, Math.abs(root.val-pre.val));
        }
        pre = root;
        getMin(root.right);
    }
}