
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution_129 {
    int sum;
    int cur;
    // 自己的写法，先序遍历
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return sum;
    }
    
    public void dfs(TreeNode root) {
        if(root == null) return;
        if(root.left==null && root.right==null) {
            sum += cur*10 + root.val;
            return;
        }
        cur = cur*10 + root.val;
        dfs(root.left);
        dfs(root.right);
        cur = cur/10;
    }
}