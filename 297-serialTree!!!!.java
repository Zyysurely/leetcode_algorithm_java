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

class Codec_297 {
    // 层次遍历序列化和反序列化
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()!=0) {
            TreeNode val = queue.poll();
            if(val == null) {
                res.append("null,");
            } else {
                res.append(val.val);
                res.append(",");
                queue.add(val.left);
                queue.add(val.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] str_word = data.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(str_word));
        if(queue.peek() == null) return null;
        TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
        Queue<TreeNode> qu = new LinkedList<TreeNode>(); 
        qu.add(root);
        while(queue.peek()!=null){
            int num = qu.size();
            while(num>0) {
                TreeNode node = qu.poll();
                String l = queue.poll();
                String r = queue.poll();
                node.left = generate(l);
                if(node.left!=null) qu.add(node.left);
                node.right = generate(r);
                if(node.right!=null) qu.add(node.right);
                num--;
            }
        }
        return root;
    }

    public String serialize_dfs(TreeNode root) {
        if(root == null) return null;
        StringBuilder res = new StringBuilder();
        ser_helper(root, res);
        return res.toString();
    }
    
    public StringBuilder ser_helper(TreeNode root, StringBuilder res) {
        if(root == null){
            res.append("null,");
            return res;
        }
        res.append(root.val);
        res.append(",");
        ser_helper(root.left, res);
        ser_helper(root.right, res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_dfs(String data) {
        if(data == null) return null;
        String[] str_word = data.split(",");
        // 得用这种动态的数组传入才可以，不然无法传出index
        Queue<String> list_word = new LinkedList<String>(Arrays.asList(str_word));
        return deser_helper(list_word);
    }
    
    public TreeNode deser_helper(Queue<String> data) {
        TreeNode node = generate(data.poll());
        if(node==null) return null;
        node.left = deser_helper(data);
        node.right = deser_helper(data);
        return node;
    }
    
    public TreeNode generate(String l) {
        if(l.equals("null")) {
            return null;
        } else return new TreeNode(Integer.valueOf(l));
    }



}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));