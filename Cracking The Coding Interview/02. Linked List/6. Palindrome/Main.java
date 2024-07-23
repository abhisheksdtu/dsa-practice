/*
 * Implement a function to check if a linked list is a palindrome
 */

public class Main {
    public static boolean bruteIsPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        boolean res = true;

        Node mid = middle(head);
        Node nHead = mid.next;
        mid.next = null;
        nHead = reverse(nHead);

        Node p1 = head;
        Node p2 = nHead;

        while (p2 != null) {
            if (p1.data != p2.data) {
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        nHead = reverse(nHead);
        mid.next = nHead;

        return res;
    }

    public static Node middle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node nbr = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nbr;
        }

        return prev;
    }

    public static void main(String[] args) {
        int list[] = new int[] { 1, 2, 3, 2, 1 };
        Node head = createLinkedList(list);
        printLinkedList(head);
        System.out.println(bruteIsPalindrome(head));
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
