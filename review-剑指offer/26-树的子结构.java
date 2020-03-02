
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
} 


class Solution_offer_26 {
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2) || isSubTree(root1, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) { //确定根部判断子树
        if(root1 == null) return false;
        if(root2 == null) return true;
        if(root1.val != root2.val) return false;
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}