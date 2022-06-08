package easy;

import java.util.HashMap;
import java.util.Map;

public class Q383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c :ransomNote.toCharArray()){
            if (charMap.containsKey(c)){
                charMap.put(c, charMap.get(c) + 1);
            }
            else{
                charMap.put(c, 1);
            }
        }
        for (char c: magazine.toCharArray()){
            if (charMap.containsKey(c)){
                if (charMap.get(c) == 1){
                    charMap.remove(c);
                    continue;
                }
                else{
                    charMap.put(c, charMap.get(c) -1);
                }
            }
        }
        return charMap.isEmpty();
    }
}
