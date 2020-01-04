/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 二叉树的中序遍历
class Solution_230 {
    private int count = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        midOrder(root, k);
        return res;
    }
    
    public void midOrder(TreeNode root, int k){
        if(root == null) return ;
        midOrder(root.left, k);
        if(++count == k) {
            res = root.val;
            return;
        }
        midOrder(root.right, k);
    }
}