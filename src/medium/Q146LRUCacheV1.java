package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q146LRUCacheV1 {

    /**
     *  Queue Approach
     *  put: O(n)
     *  get: O(n)
     */
    private Map<Integer, Integer> map;
    private Queue<Integer> opQueue;
    private int capacity;
    public Q146LRUCacheV1(int capacity) {
        this.map = new HashMap<>();
        this.opQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = map.get(key);
        if (result == null) return -1;

        opQueue.remove(key);
        opQueue.offer(key);

        return result;
    }

    public void put(int key, int value) {
        if (map.get(key) == null){
            if (map.size() >= capacity){
                map.remove(opQueue.poll());
            }
        }else{
            opQueue.remove(key);
        }
        opQueue.offer(key);
        map.put(key, value);

    }
}
