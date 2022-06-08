package easy;

import dataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q141LinkedListCycle {
    /**
     * Hash Hack, Time: O(n), Space: O(n);
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        while (head != null){
            if (hashSet.contains(head)) return true;
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * Floyd's algorithm
     * given two pointer iterate the linked list with different speed,
     * if the list is a cycle, they will eventually collide.
     * Time: O(n)
     * Space: O(1)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null && slow != null){
            if (fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
