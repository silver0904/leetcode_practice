package easy;

import java.util.Stack;

public class Q155MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Q155MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }

    public void pop() {
        int x = minStack.peek();
        int y = stack.pop();
        if (x == y){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
