/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode pre = root;
        TreeNode head = root;
        while(root != null){
            pre = root;
            if(root.val > val)
                root = root.left;
            else if(root.val < val)
                root = root.right;
            else{
                return root;
            }
        }
        root = pre;
        if(root.val > val){
            root.left = new TreeNode(val);
        } else {
            root.right = new TreeNode(val);
        }
        return head;
    }
}