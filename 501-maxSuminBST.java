import java.util.*;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 // 中序遍历时是有序的，有序数组的众数问题

 class Solution_501 {
    int pre=0, cur=0, max=0;
    ArrayList<Integer> res = new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int size = res.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(pre == root.val) {
            cur++;
        } else {
            pre=root.val;
            cur=1;
        }
        if(cur == max) res.add(root.val);
        else if(cur > max) {
            res.clear();
            max = cur;
            res.add(root.val);
        }
        inOrder(root.right);
    }
}