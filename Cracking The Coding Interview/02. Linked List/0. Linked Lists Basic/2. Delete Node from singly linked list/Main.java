public class Main {

    public static Node removeNode(Node head, int data) {
        if (head.data == data) {
            return head;
        }

        Node node = head;

        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
                return head;
            }
            node = node.next;
        }
        return head;        
    }

    public static void main(String[] args) {
        int list[] = new int[] { 1, 7, 3, 8, 9, 4 };
        Node head = createLinkedList(list);
        printLinkedList(head);
        removeNode(head, 8);
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
