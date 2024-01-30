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
    private int max;

    public int diameterOfBinaryTree(TreeNode node) {
        diameter(node);
        return max;
    }

    public void diameter(TreeNode node) {
        if (node == null) {
            return;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        max = Math.max(max, lh + rh);

        diameter(node.left);
        diameter(node.right);
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
    public int max;

    public int diameterOfBinaryTree(TreeNode root) {
        height(node);
        return max;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        max = Math.max(max, lh + rh);

        return Math.max(lh, rh) + 1;
    }
}