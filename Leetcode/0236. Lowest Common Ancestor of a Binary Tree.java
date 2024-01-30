/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
/*
 * BRUTE ->
 * 1. FIND ROOT TO NODE PATH OF BOTH NODES
 * 2. REVERSE BOTH LISTS AND ITERATE BOTH OF THEM SIMULTANEOUSLY
 * 3. WHEN ANY ONE OF THE LIST'S VALUE IS NOT EQUAL THEN THE PREVIOUS ONE IS THE
 * LCA
 * 
 * TC - O(N)
 * SC - O(N)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        ArrayList<TreeNode> pp = new ArrayList<>();
        ArrayList<TreeNode> qq = new ArrayList<>();

        nodeToRootPath(root, p, pp);
        nodeToRootPath(root, q, qq);

        Collections.reverse(pp);
        Collections.reverse(qq);

        int i = 0;
        TreeNode lca = null;
        while (i < pp.size() && i < qq.size() && pp.get(i) == qq.get(i)) {
            lca = pp.get(i);
            i++;
        }

        return lca;
    }

    public boolean nodeToRootPath(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
        if (root == null) {
            return false;
        }

        if (root.val == node.val) {
            list.add(root);
            return true;
        }

        boolean left = nodeToRootPath(root.left, node, list);
        if (left) {
            list.add(root);
            return true;
        }

        boolean right = nodeToRootPath(root.right, node, list);
        if (right) {
            list.add(root);
            return true;
        }

        return false;
    }
}

/*
 * OPTIMIZED
 * 
 * TC - O(N)
 * SC - O(N)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}