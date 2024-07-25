/*
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting. 
 */

import java.util.*;

public class Main {
    /*
     * TC - O(N + M)
     * SC - O(N)
     */
    public static Node bruteIntersecting(Node m, Node n) {
        Set<Node> set = new HashSet<>();

        Node node = m;
        while (node != null) {
            set.add(node);
            node = node.next;
        }

        node = n;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    /*
     * TC - O(N + M)
     */
    public static Node optimizedIntersecting(Node m, Node n) {
        if (m == null || n == null) {
            return null;
        }

        Node p1 = m;
        Node p2 = n;

        while (p1 != p2) {
            p1 = p1 != null ? p1.next : n;
            p2 = p2 != null ? p2.next : m;
        }

        return p1;
    }

    public static void main(String[] args) {
        Node common = new Node(8);
        common.next = new Node(10);

        int[] list1 = { 3, 6, 9 };
        Node head1 = createLinkedList(list1);
        appendNode(head1, common);

        int[] list2 = { 5 };
        Node head2 = createLinkedList(list2);
        appendNode(head2, common);

        printLinkedList(head1);
        printLinkedList(head2);

        Node intersectingNode = optimizedIntersecting(head1, head2);

        if (intersectingNode != null) {
            System.out.println("Intersecting node data: " + intersectingNode.data);
        } else {
            System.out.println("No intersection");
        }
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

    public static void appendNode(Node head, Node node) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }
}
