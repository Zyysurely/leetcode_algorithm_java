import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution_652 {
    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map= new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        post(root);
        return res;
    }
    // 后续遍历
    StringBuilder post(TreeNode root) {
        if(root == null) return new StringBuilder("$");
        StringBuilder left = post(root.left);
        StringBuilder right = post(root.right);
        StringBuilder key = new StringBuilder(root.val+"").append(left).append(right);
        map.put(key.toString(), map.getOrDefault(key.toString(), 0)+1);
        if(map.get(key.toString()) == 2) {
            res.add(root);
        }
        return key;
    }
}