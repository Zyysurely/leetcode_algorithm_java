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

class Solution_199 {
    // 层次遍历的问题，每一层的最右边
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()!=0) {
            int count = queue.size();
            TreeNode left=null;
            for(int i=0; i<count; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
                if(i==count-1){
                    left = node;}
            }
            if(left != null) {
                res.add(left.val);
            }
            
        }
        return res;
    }

}