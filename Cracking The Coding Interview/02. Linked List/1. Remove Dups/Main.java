/*
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */

import java.util.*;

public class Main {

    public static Node bruteRemoveDups(Node head) {
        Set<Integer> set = new HashSet<>();

        Node prev = head;
        set.add(head.data);
        Node curr = head.next;
        while (curr != null) {
            if (!set.contains(curr.data)) {
                set.add(curr.data);
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }
        prev.next = curr;

        return prev;
    }
    
    public static Node optimizedRemoveDups(Node head) {
        Node node = head;

        while (node != null) {
            Node curr = node;

            while (curr.next != null) {
                if (curr.next.data == node.data) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int list[] = new int[] { 1, 1, 9, 8, 3, 3 };
        Node head = createLinkedList(list);
        printLinkedList(head);
        optimizedRemoveDups(head);
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
