package medium;

import dataStructure.TreeNode;

public class Q98ValidateBinarySearchTree {
    /**
     * DFS approach with range logic
     * Main concept to know, for a valid BST,
     * a left node value l should be: current node value > l > distant root value
     * a right node value r should be: current node value < r < distant root value
     *
     *          5
     *        /  \
     *       3    7
     *        \  /
     *        R  L
     * To make the BST valid in this case, 7 > L > 5, and 3 < R < 5
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean validate(TreeNode node, long upper, long lower){
        if (node == null) return true;
        if (node.val >= upper || node.val <= lower){
            return false;
        }
        return validate(node.left, node.val, lower) &&
                validate(node.right, upper, node.val);

    }

}
