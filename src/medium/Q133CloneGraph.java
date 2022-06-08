package medium;

import dataStructure.Node;

import java.util.HashMap;
import java.util.Map;

public class Q133CloneGraph {
    Map<Node, Node> oldToNew = new HashMap<>();
    public Node cloneGraph(Node node) {
        return clone(node);

    }
    public Node clone(Node node){
        if (node == null)return null;
        Node cloned = oldToNew.get(node);
        if (cloned != null) return cloned;
        cloned = new Node(node.val);
        oldToNew.put(node, cloned);
        for (Node neighbors : node.neighbors){
            cloned.neighbors.add(clone(neighbors));
        }
        return cloned;
    }
}
