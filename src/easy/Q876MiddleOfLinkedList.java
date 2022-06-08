package easy;

import dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q876MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode node = head;
        ListNode ans = head;
        while(node!= null){
            size ++;
            node = node.next;
            if (size % 2 == 0){
                ans = ans.next;
            }
        }
        return ans;
    }
}
