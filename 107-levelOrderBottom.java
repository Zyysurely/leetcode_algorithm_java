import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 还是用队列来实现，结果插入的时候插的队头就可以了
class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            LinkedList<Integer> one = new LinkedList<Integer>();
            for(int i=0; i<count; i++){
                TreeNode node = queue.poll();
                one.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.addFirst(one);
        }
        return res;
    }
}