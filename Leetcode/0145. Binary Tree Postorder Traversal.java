/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * RECURSIVE
 * TC - O(N)
 * SC - O(N)
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);

    }
}

/*
 * ITERATIVE - 2 STACKS
 * TC - O(N)
 * SC - O(N)
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);

            if (node.left != null) st1.push(node.left);
            if (node.right != null) st1.push(node.right);
        }

        while (!st2.isEmpty()) {
            list.add(st2.pop().val);
        }

        return list;
    }
}