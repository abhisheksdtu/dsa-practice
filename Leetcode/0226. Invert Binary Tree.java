class Solution {
    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return node;
        }

        TreeNode left = invertTree(node.left);
        TreeNode right = invertTree(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
}