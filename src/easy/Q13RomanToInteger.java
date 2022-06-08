package easy;

import java.util.Map;

public class Q13RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> characterMap = Map.of(
                'I', 1,
                'V',5,
                'X',10,
                'L',50,
                'C',100,
                'D',500,
                'M',1000
        );
        Character lastChar = null;
        int result = 0;
        for (int i = s.length(); i > 0; i--){
            char currentChar = s.charAt(i-1);
            if (lastChar != null && characterMap.get(lastChar)> characterMap.get(currentChar)){
                result -= characterMap.get(currentChar);
            }else{
                result += characterMap.get(currentChar);
            }
            lastChar = currentChar;
        }
        return result;
    }
}
