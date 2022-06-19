package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q146LRUCacheV2 {

    /**
     *  Double Linked List Approach
     *  put: O(1)
     *  get: O(1)
     */
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    public Q146LRUCacheV2(int capacity) {
        this.map = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0) return -1;
        Node node = map.get(key);
        if (node == null){
            return -1;
        }
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        if (map.size() == capacity) {
            removeNode(head.next);
        }
        addNode(new Node(key, value));
    }

    private void addNode(Node node){
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
        map.put(node.key, node);
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    private class Node{
        int val;
        int key;
        Node prev;
        Node next;

        public Node(){}
        public Node(int key, int val){
            this.val = val;
            this.key = key;
        }

    }
}
