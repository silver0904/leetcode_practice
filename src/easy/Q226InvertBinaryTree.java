package easy;

import dataStructure.TreeNode;

public class Q226InvertBinaryTree {

    /**
     * Explanation: Before invert a parent node, we invert its child nodes first, so use recursion to achieve this
     * Time: O(n), n = number of nodes;
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        invertLeftRight(root);
        return root;
    }

    private void invertLeftRight(TreeNode node){
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
    }
}
