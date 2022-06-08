package easy;

import dataStructure.ListNode;

import java.util.Stack;

public class Q206ReverseLinkedList {
    /**
     * Stack approach
     * Time: O(n)
     * Space: O(n)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        while (!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return result.next;
    }

    /**
     * Normal Answer:
     * get the first node of the list,
     * set the next of the node to the previous first node we retrieved
     * this way we can put the first node of current list to the last first node of the list
     * -- Iteration 0
     * head: 1->2->3->4->null
     * prev: null
     * -- Iteration 1
     * head: 2->3->4->null
     * prev: 1->null
     * -- Iteration 2
     * head: 3->4->null
     * prev: 2->1->null
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
