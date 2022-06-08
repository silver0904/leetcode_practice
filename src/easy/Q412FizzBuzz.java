package easy;

import java.util.ArrayList;
import java.util.List;

public class Q412FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i=1; i<= n; i++){
            String s = "";
            if (i % 3 == 0) {
                s = "Fizz";
            }
            if (i % 5 == 0){
                s += "Buzz";
            }
            if (s.isBlank()){
                s = Integer.toString(i);
            }
            ans.add(s);
        }
        return ans;
    }

}
