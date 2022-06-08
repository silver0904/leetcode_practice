package medium;

import dataStructure.ListNode;

import java.util.List;

public class Q2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode l3 = result;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int subTotal = val1 + val2 + carry;
            carry = subTotal >= 10 ? 1 : 0;
            l3.val = subTotal%10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            if (l1 != null || l2 != null){
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
        }
        if (carry> 0){
            l3.next = new ListNode(carry);
        }
        return result;
    }
}
