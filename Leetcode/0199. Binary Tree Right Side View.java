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
 * BRUTE -> USE LEVEL ORDER TRAVERSAL & GET THE LAST ELEMENT OF EACH LEVEL
 * 
 * 
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> right = new ArrayList<>();
        List<List<Integer>> level = levelOrder(root);

        for (int i = 0; i < level.size(); i++) {
            List<Integer> temp = level.get(i);
            right.add(temp.get(temp.size() - 1));
        }

        return right;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            while (size-- > 0) {
                TreeNode curr = queue.remove();
                list.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }

            ans.add(list);
        }

        return ans;
    }
}

/*
 * OPTIMAL
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideView(root, res, 0);
        return res;
    }

    public void rightSideView(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }

        if (level == res.size()) {
            res.add(node.val);
        }

        rightSideView(node.right, res, level + 1);
        rightSideView(node.left, res, level + 1);
    }
}