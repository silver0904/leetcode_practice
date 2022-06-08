package medium;

import java.util.*;

public class Q3LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        char[] arr = s.toCharArray();
        LinkedList<Character> result = new LinkedList<>();
        for (int i=0; i<arr.length; i++){
            int matchedIndex = result.indexOf(arr[i]);
            if (matchedIndex >= 0){
                maxSize = maxSize > result.size() ? maxSize: result.size();
                for (int j=0; j<= matchedIndex; j++){
                    result.removeFirst();
                }
            }
            result.add(arr[i]);
        }
        return result.size() > maxSize? result.size() : maxSize;
    }
}
