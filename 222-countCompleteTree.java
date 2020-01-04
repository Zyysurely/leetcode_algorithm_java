/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_222 {
    public int countNodes(TreeNode root) {
        // 简单的分治
        if(root == null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    // 根据左右子树的高度情况，利用了完全二叉树的性质
    public int countNodes_2(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        // 左子树不一定满，右子树满
        if(left == right + 1) return countNodes(root.left) + (1<<right);
        else return countNodes(root.right) + (1<<left);
        
    }
    // 直接访问左子树得到深度
    public int depth(TreeNode root) {
        int count = 0;
        while(root != null) {
            count ++;
            root = root.left;
        }
        return count;
    }
}