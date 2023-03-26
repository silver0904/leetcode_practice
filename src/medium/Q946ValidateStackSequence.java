package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q946ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Map<Integer, Integer> posMap = new HashMap<Integer, Integer>();
        for (int i=0; i< pushed.length; i++){
            posMap.put(pushed[i], i);
        }
        Stack<Integer> posStack = new Stack<Integer>();
        Integer prevPos = null;

        for (int i=0; i<popped.length; i++){
            int pos = posMap.get(popped[i]);
            if (posStack.isEmpty()){
                prevPos = pos;
                if (pos != 0){
                    for (int j=0; j< pos; j++){
                        posStack.push(j);
                    }
                }
                continue;
            }
            // increasing sequence
            if (pos > prevPos){
                if (pos != prevPos +1){
                    for (int j= prevPos+1; j< pos; j++)
                        posStack.push(j);
                }
                prevPos = pos;
            }
            // decreasing sequence
            else {
                if (posStack.peek() != pos)
                    return false;
                posStack.pop();
            }

        }
        return true;
    }
}
