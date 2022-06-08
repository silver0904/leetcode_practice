package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q242ValidAnagram {
    /**
     * Use hashMap to keep track characters in string s
     * and find out if the correct number of characters appear in string t
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> hashMap = new HashMap();
        for (char c : s.toCharArray()){
            hashMap.put(c, hashMap.containsKey(c)? hashMap.get(c) + 1: 1);
        }
        for (char c : t.toCharArray()){
            Integer result = hashMap.get(c);
            if (result == null || result == 0) {
                return false;
            }else{
                hashMap.put(c, result -1);
            }
        }
        return true;
    }
}
