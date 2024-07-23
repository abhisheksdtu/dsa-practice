/*
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
 * EXAMPLE 
 * Input:the node c from the linked list : a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */

public class Main {

    public static void bruteDeleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int list[] = new int[] { 5, 4, 3, 2, 1 };
        Node head = createLinkedList(list);
        printLinkedList(head);
        Node node = head.next.next;
        bruteDeleteNode(node);
        printLinkedList(head);
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
