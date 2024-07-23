/*
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912. 
 */

public class Main {

    public static Node bruteReverseSumLists(Node m, Node n) {
        if (m == null || n == null) {
            return m == null ? n : m;
        }

        Node dummy = new Node(-1);
        Node p1 = m;
        Node p2 = n;
        Node node = dummy;
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0) {
            int mNodeVal = p1 != null ? p1.data : 0;
            int nNodeVal = p2 != null ? p2.data : 0;

            int sum = mNodeVal + nNodeVal + carry;
            carry = sum / 10;
            sum = sum % 10;

            Node sumNode = new Node(sum);
            node.next = sumNode;

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
            node = node.next;
        }

        return dummy.next;
    }

    /*
     * FOR FORWARD SUMMATION
     * 
     * APPROACH 1
     * 1. REVERSE BOTH LISTS AND ADD THEM IN THE ABOVE MANNER
     * 
     * APPROACH 2 
     * 1. CREATE 2 STACKS AND FILL ELEMENTS IN BOTH OF THEM FROM THE LISTS
     * 2. NOW POP FROM ELEMENTS AND DO SUMMATION IN REVERE ORDER
     */

    public static void main(String[] args) {
        int mArr[] = new int[] { 7, 1, 6 };
        int nArr[] = new int[] { 5, 9, 2 };
        Node m = createLinkedList(mArr);
        Node n = createLinkedList(nArr);
        printLinkedList(m);
        printLinkedList(n);
        Node ans = bruteReverseSumLists(m, n);
        printLinkedList(ans);
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node createLinkedList(int list[]) {
        Node head = new Node(list[0]);
        Node prev = head;
        for (int i = 1; i < list.length; i++) {
            Node node = new Node(list[i]);
            prev.next = node;
            prev = prev.next;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        System.out.println("PRINTING LINKED LIST");
        Node node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
