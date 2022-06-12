package medium;

import dataStructure.TreeNode;

import java.util.*;

public class Q236LowestCommonAncestorOfBT {
    /**
     * Time: O(n) + O(n)    dfs + queue iteration
     * Space: O(n)
     */
    public TreeNode lowestCommonAncestorDfs(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> targets = new HashSet<>(Set.of(p,q));
        List<Queue<TreeNode>> nodeList = new ArrayList<>();
        dfs(root, targets, new Stack<>(), nodeList);

        TreeNode lca = root;
        while (!nodeList.get(0).isEmpty() && !nodeList.get(1).isEmpty()){
            TreeNode node1 = nodeList.get(0).poll();
            TreeNode node2 = nodeList.get(1).poll();
            if (node1 != node2){
                break;
            }
            lca = node1;
        }
        return lca;

    }

    public void dfs (TreeNode node, Set<TreeNode> targets, Stack<TreeNode> stack, List<Queue<TreeNode>> result){
        if (targets.isEmpty() || node == null) return;
        stack.push(node);
        if (targets.contains(node)){
            targets.remove(node);
            result.add(new ArrayDeque<>(stack));
        }
        dfs(node.left, targets, stack, result);
        dfs(node.right, targets, stack, result);
        stack.pop();
    }

    /**
     * Model Answer
     * Time: O(n)
     * Space: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }

        if (left == null && right != null) {
            return right;
        }

        if (right == null && left != null) {
            return left;
        }

        return root;
    }
}
