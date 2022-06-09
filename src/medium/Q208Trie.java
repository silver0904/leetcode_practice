package medium;

import java.util.*;

public class Q208Trie {
    private class Node{
        Node[] children;
        boolean eow;
        public Node(){
            this.children = new Node[26];
            this.eow = false;
        }
    }
    Node root;
    public Q208Trie() {
        this.root = new Node();
    }

    public void insert(String word){
        if (word.isBlank()) return;
        Node cur = root;
        for (char c : word.toCharArray()){
            Node newNode = cur.children[c - 'a'];
            if (newNode == null) {
                newNode = new Node();
                cur.children[c - 'a'] = newNode;
            }
            cur = newNode;
        }
        cur.eow = true;
    }

    public boolean search(String word) {
        if (word.isBlank()){
            return false;
        }
        Node node = root;
        for (char c : word.toCharArray()){
            if (node.children[c-'a'] == null){
                return false;
            }
            node = node.children[c-'a'];
        }
        return node.eow;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isBlank()){
            return false;
        }
        Node node = root;
        for (char c : prefix.toCharArray()){
            if (node.children[c-'a'] == null){
                return false;
            }
            node = node.children[c-'a'];
        }
        return true;
    }

}
