/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_450 {
    // root的前继
    private int before(TreeNode root) {
        root = root.left;
        while(root.right!=null) root = root.right;
        return root.val;
    }

    // root的后继
    private int after(TreeNode root) {
        root = root.right;
        while(root.left!=null) root=root.left;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        return searchKey(root, key);
    }

    public TreeNode searchKey(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null && root.right == null) {
                root = null;
                return null;
            }
            if(root.right != null) {
                root.val = after(root);
                root.right = searchKey(root.right, root.val);
            } else {
                root.val = before(root);
                root.left = searchKey(root.left, root.val);
            }
        }
        if(root.val < key) root.right = searchKey(root.right, key);
        else root.left = searchKey(root.left, key);
        return root;
    }
}