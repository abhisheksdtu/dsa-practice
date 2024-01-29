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
 * BRUTE
 * TC - O(N^2)
 * SC - O(1)
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1) {
            return false;
        }

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (left == false || right == false) {
            return false;
        }
        return true;
    }

    public int height(TreeNode node) {
        return node == null ? 0 : Math.max(height(node.left), height(node.right)) + 1;
    }
}

/*
 * OPTIMIZED
 * TC - O(N)
 * SC - O(1)
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root) != -1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return 0;

        int lh = height(root.left);
        if (lh == -1) return -1;

        int rh = height(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }
}