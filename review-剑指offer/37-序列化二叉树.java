class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {val = x;}
}

class Solution_offer_37 {
    public String Serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode DeSerialize(String s) {
        if(s.length() == 0) return null;
        int index = s.indexOf(" ");
        String node = index == -1 ? s : s.substring(0, index);
        if(node.equals("#")) return null;
        s = index == -1 ? "" : s.substring(index+1);
        int spli = s.indexOf(" ");
        TreeNode root = new TreeNode(Integer.valueOf(node));
        root.left = DeSerialize(s.substring(1, spli));
        root.right = DeSerialize(s.substring(spli+1));
        return root;
    }
}