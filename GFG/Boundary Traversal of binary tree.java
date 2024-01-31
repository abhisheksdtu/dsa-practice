// class Node  
// { 
//     int data; 
//     Node left, right; 

//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

/*
 * ADD LEFT BOUNDARY THEN LEAVES THEN ADD RIGHT BOUNDARY
 */
class Solution {
    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (!isLeaf(root)) {
            res.add(root.data);
        }

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.left;

        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    void addLeaves(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        // if (root.left != null) {
            addLeaves(root.left, res);
        // }
        // if (root.right != null) {
            addLeaves(root.right, res);
        // }

    }

    void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.right;

        ArrayList<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }

            for (int i = temp.size() - 1; i >= 0; --i) {
                res.add(temp.get(i));
            }
        }
    }
}
