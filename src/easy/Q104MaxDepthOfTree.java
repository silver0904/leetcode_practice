package easy;

import dataStructure.TreeNode;

public class Q104MaxDepthOfTree {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
