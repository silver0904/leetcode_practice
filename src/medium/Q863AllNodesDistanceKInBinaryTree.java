package medium;

import dataStructure.TreeNode;

import java.util.*;

public class Q863AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
        constructChildParentMap(root, childParentMap);

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        int height = 0;

        while(!queue.isEmpty() && height <= k){
            int qLen = queue.size();
            for (int i=0; i<qLen; i++){
                TreeNode node = queue.poll();
                if (node == null || visited.contains(node)){
                    continue;
                }
                visited.add(node);
                if (height == k){
                    result.add(node.val);
                }
                queue.offer(node.left);
                queue.offer(node.right);
                queue.offer(childParentMap.get(node));
            }
            height++;
        }

        return result;

    }


    private void constructChildParentMap(TreeNode root, Map<TreeNode,TreeNode> childParentMap){
        if (root == null) return;
        if (root.left != null){
            childParentMap.put(root.left, root);
        }
        if (root.right != null){
            childParentMap.put(root.right, root);
        }
        constructChildParentMap(root.left, childParentMap);
        constructChildParentMap(root.right, childParentMap);
    }
}
