package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q652FindDuplicateSubtree {
    private Map<String, Integer> countMap = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrderTraversal(root);
        return result;
    }

    private String postOrderTraversal(TreeNode node) {
        if (node == null) {
            return "";
        }
        String leftSubtree = postOrderTraversal(node.left);
        String rightSubtree = postOrderTraversal(node.right);
        String subtree = node.val + "," + leftSubtree + "," + rightSubtree;
        int count = countMap.getOrDefault(subtree, 0);
        if (count == 1) {
            result.add(node);
        }
        countMap.put(subtree, count + 1);
        return subtree;
    }
}
