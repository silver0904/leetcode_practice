package easy;

import java.util.Stack;

public class Q20ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c =='{' || c == '['){
                parentheses.push(c);
                continue;
            }
            else if (parentheses.isEmpty()){
                return false;
            }
            else if (c == ')' && parentheses.pop() != '('){
                return false;
            }
            else if (c == '}' && parentheses.pop() != '{'){
                return false;
            }
            else if (c == ']' && parentheses.pop() != '['){
                return false;
            }
        }
        if (parentheses.isEmpty()) return true;
        return false;
    }
}
