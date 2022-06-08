package easy;

import dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Q234IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> integerStack = new Stack<>();
        ListNode currentHead = head;
        while (currentHead != null){
            integerStack.push(currentHead.val);
            currentHead = currentHead.next;
        }
        currentHead = head;
        while(currentHead != null){
            if (integerStack.pop() != currentHead.val){
                return false;
            }
            currentHead = currentHead.next;
        }
        return true;
    }
}
