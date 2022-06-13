package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q981TimeMap {
    private class Pair{
        int timestamp;
        String value;
        public Pair(String value, int timestamp){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String, List<Pair>> pairMap;
    public Q981TimeMap() {
        pairMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        pairMap.putIfAbsent(key, new ArrayList<>());
        pairMap.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair>pairList = pairMap.get(key);
        if (pairList == null) return null;
        int start = 0;
        int end = pairList.size() - 1;
        String res = "";
        while (start <= end) {
            int m = start + (end - start) / 2;
            Pair mid = pairList.get(m);
            if (mid.timestamp <= timestamp) {
                res = mid.value;
                start = m + 1;
            } else {
                end = m - 1;
            }
        }
        return res;
    }
}
