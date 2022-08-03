package medium;

import java.util.HashMap;
import java.util.Map;

public class Q138CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node copyHead = new Node(0);

        Node copied = copyHead;
        Node source = head;
        while(source != null){
            // copy the node without random value first
            copied.next = new Node(source.val);
            copied = copied.next;

            nodeMap.put(source, copied);
            source = source.next;

        }

        source = head;
        copied = copyHead.next;
        while(source != null){
            if (source.random != null){
                Node copiedRandom = nodeMap.get(source.random);
                copied.random = copiedRandom;
            }
            source = source.next;
            copied = copied.next;
        }

        return copyHead.next;

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
