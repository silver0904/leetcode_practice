package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199BTRightSideView {
    /**
     * BFS Approach
     * Time: O(n)
     * Space: O(n)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int qLen = queue.size();
            Integer right = null;
            for(int i=0; i< qLen; i++){
                TreeNode node = queue.poll();
                if (right == null){
                    right = node.val;
                }
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
            result.add(right);
        }
        return result;
    }
}
