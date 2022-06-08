package medium;

import dataStructure.TreeNode;

import java.util.*;

public class Q102BTLevelOrderTraversal {
    /**
     * DFS Approach:
     * Time: O(n^2)
     * Space: o(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        traverse(root, result, 1);
        return result;

    }

    public void traverse(TreeNode root, List<List<Integer>> result, int height){
        if (root == null){
            return;
        }
        List<Integer> list = result.size() >= height ? result.get(height -1) : new LinkedList<>();
        list.add(root.val);
        if (result.size() >= height){
            result.remove(height-1);
            result.add(height-1, list);
        }else{
            result.add(list);
        }

        traverse(root.left, result,height + 1);
        traverse(root.right, result,height + 1);

    }

    /**
     * BFS Approach (Model answer)
     * Time: O(n)
     * Space: O(n)
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int qLen = queue.size();
            for (int i=0; i< qLen; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
