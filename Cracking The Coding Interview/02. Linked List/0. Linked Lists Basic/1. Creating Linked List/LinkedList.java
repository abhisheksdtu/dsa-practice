public class LinkedList {

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
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int list[] = new int[] { 1, 7, 3, 8, 9, 4 };
        Node head = createLinkedList(list);
        printLinkedList(head);
    }
}
