package easy;

import java.util.Stack;

public class Q232ImplementQueueWithStacks_Review {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public Q232ImplementQueueWithStacks_Review() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        while (!popStack.empty()){
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }

    public int pop() {
        while (!pushStack.empty()){
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    public int peek() {
        while (!pushStack.empty()){
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
