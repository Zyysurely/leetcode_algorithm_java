/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return generate(1, n);
    }
    
    public List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> subLeftTree = generate(start, i-1);
            List<TreeNode> subRightTree = generate(i+1, end);
            for(TreeNode left : subLeftTree){
                for(TreeNode right : subRightTree){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}