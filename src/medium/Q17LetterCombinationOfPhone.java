package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q17LetterCombinationOfPhone {
    /**
     * Fake DP approach
     * Time: O( 4^n)
     * Space: O(4^n)
     */
    Map<Character, List<String>> digitToLettersMap = Map.of(
            '2', List.of("a","b","c"),
            '3', List.of("d","e","f"),
            '4', List.of("g","h","i"),
            '5', List.of("j","k","l"),
            '6', List.of("m","n","o"),
            '7', List.of("p","q","r","s"),
            '8', List.of("t","u","v"),
            '9', List.of("w","x","y","z")
    );
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        LinkedList<List<String>> dp = new LinkedList<>();
        dp.add(digitToLettersMap.get(digits.charAt(0)));

        for (int i=1 ; i< digits.length() ; i++){
            List<String> prev = dp.getLast();
            List<String> cur = digitToLettersMap.get(digits.charAt(i));
            List<String> newComb = new ArrayList<>();
            for (String prevChar: prev){
                for (String curChar: cur){
                    newComb.add(prevChar+ curChar);
                }
            }
            dp.removeFirst();
            dp.add(newComb);
        }

        return dp.getLast();

    }

}
