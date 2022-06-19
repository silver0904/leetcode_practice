package medium;

import java.util.*;

public class Q438FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length())
            return result;
        HashMap<Character,Integer> countMap = new HashMap<>();
        for (char ch : p.toCharArray())
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
        HashMap<Character,Integer> temp = new HashMap<>();
        temp.putAll(countMap);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!temp.containsKey(curr)) {
                start = i+1;
                temp.putAll(countMap);
            } else if (temp.get(curr)<=0){
                i--;
                temp.put(s.charAt(start),temp.get(s.charAt(start))+1);
                start++;
            } else if (i-start == p.length()-1){
                result.add(start);
                temp.put(curr,temp.get(curr)-1);
                temp.put(s.charAt(start),temp.get(s.charAt(start))+1);
                start++;
            } else
                temp.put(curr,temp.get(curr)-1);
        }
        return result;
    }
}
