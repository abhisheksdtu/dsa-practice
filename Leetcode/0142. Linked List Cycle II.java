/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

/*
 * BRUTE -> HASHING
 * 1. CREATE A SET
 * 2. ITERATE OVER LIST
 * 3. IF NODE IS PRESENT IN SET -> CYCLE PRESENT -> RETURN NODE
 * 4. ELSE RETURN NULL
 * 
 * TC - O(N)
 * SC - O(N)
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }
}

/*
 * OPTIMAL -> 2 POINTER -> SLOW & FAST POINTER
 * 1. TAKE TWO POINTER SLOW & FAST AND POINT IT TO HEAD
 * 2. MOVE SLOW BY 1 PLACE & FAST BY 2 PLACES
 * 3. IF THE POINTERS COLLIDE -> CYCLE EXISTS
 * 4. TAKE ANOTHER POINTER ENTRY & POINT IT TO HEAD
 * 5. MOVE BOTH SLOW & ENTRY BY 1 PLACE
 * 6. WHEREVER THEY MEET -> THAT IS THE STARTING POINT OF CYCLE
 * 
 * TC - O(N)
 * SC - O(1)
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }

        return null;
    }
}