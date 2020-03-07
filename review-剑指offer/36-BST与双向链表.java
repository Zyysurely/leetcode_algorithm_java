class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
}

class Solution_offer_36{
    TreeNode pre = null;
    TreeNode head = null;
    public TreeNode BSTtoList(TreeNode root) {
        if(root == null) return root;
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        root.left = pre;
        if(pre != null) {
            pre.right = root;
        }
        if(pre == null) head = root;
        pre = root;
        inOrder(root.right);
    }
}