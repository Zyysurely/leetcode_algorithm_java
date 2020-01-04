
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
class Solution_124 {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        // 从根节点的赋值开始，这种想法类似于将最大子串和
        maxValue = root.val;
        getMax(root);
        return maxValue;
    }

    // 类似于后序深度遍历，因为是可以到达任意节点
    int getMax(TreeNode root) {
        if(root == null) return 0;
        int left = getMax(root.left);
        int right = getMax(root.right);
        int val = root.val;
        maxValue = Math.max(maxValue, Math.max(left+val, Math.max(right+val,left+right+val)));
        return Math.max(val, Math.max(left+val, right+val));
    }
}