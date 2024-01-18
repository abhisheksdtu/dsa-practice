// BRUTE - 2 POINTER APPROACH
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val == val) {
                prev.next = next;
            } else {
                prev.next = curr;
                prev = curr;
            }
            curr = next;
        }

        return dummy.next;
    }
}

// BETTER -> 1 POINTER APPROACH
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}