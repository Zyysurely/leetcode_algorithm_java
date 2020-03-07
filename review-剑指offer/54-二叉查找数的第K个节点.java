class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
}

class Solution_offer_54 {
    TreeNode res = null;
    int cnt = 0;
    public TreeNode kNodeInBST(TreeNode root, int k){
        if(root == null) return root;
        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode root, int k){
        if(root == null || cnt>=k) return;
        inOrder(root.left, k);
        cnt ++;
        if(cnt == k) res = root;
        inOrder(root.right, k);
    }
}