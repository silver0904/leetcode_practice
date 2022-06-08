package easy;

import dataStructure.ListNode;

public class Q21MergeTwoSortedList {
    /**
     * Explanation: Based on the structure of linked list, it is easier for us to
     * set where does the next node point to than what is the current node value.
     * So first create a dummy node, then we manipulate its pointer in the loop.
     * After the loop is end, we can dump the dummy node by retrieving its next node as the answer.
     * Time: O(l1+l2)
     * Space: O(l1+l2)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }else{
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        current.next = list1 == null? list2 : list1;
        return result.next;
    }
}
