package medium;

import java.util.List;

public class Q139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() ==0) return false;

        boolean[] memo = new boolean[s.length()+1];
        memo[0] = true;
        for (int i= 0; i<= s.length(); i++){
            String subString = s.substring(0,i);
            System.out.println(subString);
            for (String word: wordDict){
                if (memo[i] == true) continue;
                if (word.length() > subString.length()) continue;
                if (word.length() == subString.length()){
                    memo[i] = word.equals(subString);
                    continue;
                }else{
                    boolean prev = memo[subString.length() - word.length()];
                    String subSubString = subString.substring(subString.length() - word.length());
                    if (word.equals(subSubString) && prev){
                        memo[i] = true;
                        continue;
                    }
                }

            }
        }
        return memo[s.length()];
    }
}
