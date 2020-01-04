/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution_508 {
    HashMap<Integer, Integer> count = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        postDFS(root);
        List<Integer> res = new LinkedList<>();
        for(int i:count.keySet()) {
            if(count.get(i) == max) {
                res.add(i);
            }
        }
        int[] resArr = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
    // 后续遍历解决
    public int postDFS(TreeNode root) {
        if(root == null) return 0;
        int left = postDFS(root.left);
        int right = postDFS(root.right);
        int val = left + right + root.val;
        count.put(val, count.getOrDefault(val, 0) + 1);
        max = Math.max(max, count.get(val));
        return val;
    }
}