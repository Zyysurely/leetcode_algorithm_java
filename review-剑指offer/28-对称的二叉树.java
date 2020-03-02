class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
}

class Solution_offer_28 {
    public boolean isSymmerTree(TreeNode root) {
        if(root == null) return true;
        return symmer(root.left, root.right);
    }

    private boolean symmer(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return symmer(root1.left, root2.right) && symmer(root1.right, root2.left);
    }
}