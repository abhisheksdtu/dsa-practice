/*
 *  Implement an algorithm to find the kth to last element of a singly linked list. 
 */

public class Main {

    public static Node bruteReturnKthElementFromLast(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Node node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        node = head;
        int n = size - k;
        while (n > 0) {
            node = node.next;
            n--;
        }
        return node;
    }

    public static int recursiveReturnKthElementFromLast(Node head, int k) {
        if (head == null) {
            return 0;
        }

        int idx = recursiveReturnKthElementFromLast(head.next, k) + 1;
        if (idx == k) {
            System.out.println(head.data);
        }

        return idx;
    }

    public static Node optimizedReturnKthElementFromLast(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int list[] = new int[] { 5, 4, 3, 2, 1 };
        Node head = createLinkedList(list);
        printLinkedList(head);
        recursiveReturnKthElementFromLast(head, 3);
        // Node kThNode = optimizedReturnKthElementFromLast(head, 3);
        // System.out.println(kThNode.data);
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
