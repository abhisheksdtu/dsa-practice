/*
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

import java.util.*;

public class Main {
    /*
     * TC - O(N)
     * SC - O(N)
     */
    public static Node bruteLoopDetection(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<Node> set = new HashSet<>();

        Node node = head;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }

        return null;
    }

    /*
     * TC - O(N)
     */
    public static Node optimizedLoopDetection(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // LOOP DETECTED
                break;
            }
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] list = { 3, 6, 9, 12, 15 };
        Node head = createLinkedList(list);

        Node loopStart = head.next.next;
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = loopStart;

        Node loopNode = optimizedLoopDetection(head);

        if (loopNode != null) {
            System.out.println("Loop starts at node with data: " + loopNode.data);
        } else {
            System.out.println("No loop detected");
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
