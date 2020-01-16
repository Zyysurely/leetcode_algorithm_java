/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec_449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        preOrder(root, res);
        return res.toString();
    }
    public void preOrder(TreeNode root, StringBuilder s) {
        if(root == null) return;
        s.append(root.val);
        s.append(",");
        preOrder(root.left, s);
        preOrder(root.right, s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] values = data.split(",");
        int[] pre = new int[values.length];
        for(int i=0; i<values.length; i++) {
            pre[i] = Integer.parseInt(values[i]);
        }
        return build(pre, 0, values.length-1);
        
    }
    TreeNode build(int[] pre, int l, int r) {
        if(l>r) return null;
        TreeNode root = new TreeNode(pre[l]);
        if(l == r) return root;
        int index = l+1;
        while(index <= r && pre[index] < pre[l]) {
            index++;
        }
        root.left = build(pre, l+1, index-1);
        root.right = build(pre, index, r);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));