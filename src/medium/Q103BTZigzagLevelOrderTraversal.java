package medium;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103BTZigzagLevelOrderTraversal {
    /**
     *  BFS approach with use of linkedlist
     *  Time: O(n)
     *
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }
        boolean isReverse = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int qLen = queue.size();
            LinkedList<Integer> valueInLevel = new LinkedList<>();
            isReverse = !isReverse;

            for (int i=0; i< qLen; i++){
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (isReverse){
                    valueInLevel.addFirst(node.val);
                }else{
                    valueInLevel.addLast(node.val);
                }

                queue.offer(node.left);
                queue.offer(node.right);

            }
            if (!valueInLevel.isEmpty())
            {
                result.add(valueInLevel);
            }

        }

        return result;

    }

}
