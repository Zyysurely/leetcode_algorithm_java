class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
}

class Solution_offer_55 {
    boolean res = true;
    public int depth(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(depth(root.left), depth(root.right));
    }

    public boolean isBalance(TreeNode root) {
        if(root == null) return true;
        height(root);
        return res;
    }

    private int height(TreeNode root) {
        if(root == null || !res) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right) > 1) res = false;
        return 1+Math.max(left, right);
    }
}