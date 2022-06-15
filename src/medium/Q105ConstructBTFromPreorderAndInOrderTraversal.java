package medium;

import dataStructure.TreeNode;

import java.util.*;

public class Q105ConstructBTFromPreorderAndInOrderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Queue<Integer> preorderQueue = new LinkedList<>();
        for (int i=0; i< preorder.length; i++){
            preorderQueue.offer(preorder[i]);
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i=0; i< inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        TreeNode result = constructNode(preorderQueue, inorderMap, 0, preorder.length);

        return result;



    }
    private TreeNode constructNode(Queue<Integer> preorderQueue, Map<Integer, Integer> inorderMap, int start, int end){
        if (preorderQueue.isEmpty()) return null;
        int value = preorderQueue.poll();
        TreeNode node = new TreeNode(value);
        if (start == end-1) return node;
        int inorderPos = inorderMap.get(value);
        if (inorderPos != start){
            // there is a left node exist
            node.left = constructNode(preorderQueue, inorderMap, start, inorderPos);
        }
        if (inorderPos != end -1){
            // there is a right node exist
            node.right = constructNode(preorderQueue, inorderMap, inorderPos+1, end);
        }
        return node;
    }
}
