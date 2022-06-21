package medium;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q662MaximumWidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();


        queue.offer(root);
        indexQueue.offer(1);
        int maxWidth = 1;

        while(!queue.isEmpty()){
            int qLen = queue.size();
            int start = 0;
            int end = 0;
            for (int i=0; i<qLen; i++){
                TreeNode node = queue.poll();
                int index = indexQueue.poll();

                if (i == 0) {
                    start = index;
                }
                if (i == qLen - 1) {
                    end = index;
                }

                if (node.left!= null){
                    queue.offer(node.left);
                    indexQueue.offer(index * 2);
                }
                if (node.right != null){
                    queue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            maxWidth = Math.max(maxWidth, end - start+ 1);

        }


        return maxWidth;
    }
}
