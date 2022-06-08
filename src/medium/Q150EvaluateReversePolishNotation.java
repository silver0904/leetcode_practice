package medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q150EvaluateReversePolishNotation {
    /**
     * Stack Approach:
     * Time: O(n)
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> numberStack = new Stack<>();
        Set<String> operators = Set.of("+","-","*","/");
        for (String s : tokens){

            if (operators.contains(s)){
                int val2 = Integer.valueOf(numberStack.pop());
                int val1 = Integer.valueOf(numberStack.pop());
                Integer result = 0;
                switch (s){
                    case "+":
                        result = val1 + val2;
                        break;
                    case "-":
                        result = val1 - val2;
                        break;
                    case "*":
                        result = val1 * val2;
                        break;
                    case "/":
                        result = val1 / val2;
                        break;
                }
                numberStack.push(result);
            }else{
                numberStack.push(Integer.valueOf(s));
            }
        }
        return numberStack.pop();
    }
}
