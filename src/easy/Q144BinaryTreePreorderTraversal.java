package easy;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144BinaryTreePreorderTraversal {
    // Iterative
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }

        return list;
    }

    // Recursive
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList();
        preOrder(list, root);
        return list;
    }

    private void preOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }
}
