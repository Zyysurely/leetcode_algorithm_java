import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
}


class Solution_offer_34 {
    List<List<Integer>> res  = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public void sumOfPath(TreeNode root, int sum) {
        if(root == null && sum == 0) {res.add(new ArrayList<>(cur)); return;}
        if(root == null) return;
        cur.add(root.val);
        sumOfPath(root, sum-root.val);
        sumOfPath(root, sum-root.val);
        cur.remove(res.size()-1);
    }
}