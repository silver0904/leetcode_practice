package easy;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q543DiameterOfTree {
    /**
     * Brute Force
     * for a tree diameter passing through root, it is the sum of the longest path of left and right side.
     * Since the diameter may not pass the root, it may be inside left or right side.
     * so need to return max of the following:
     * 1. diameter passing the root
     * 2. diameter passing the left node
     * 3. diameter passing the right node
     * Time: O(n^2)
     * Space: O(1)
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftPath = longestPathToLeaf(root.left);
        int rightPath =  longestPathToLeaf(root.right);
        int largestChildDiameter = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(leftPath + rightPath, largestChildDiameter);
    }

    public int longestPathToLeaf(TreeNode root){
        if (root == null) return 0;
        return (1 + Math.max(longestPathToLeaf(root.left), longestPathToLeaf(root.right)));
    }

    /**
     * Dynamic Programming Approach
     * Since in the brute force approach,
     * we find that we calculated multiple times of the longest path to leaf for a node
     * which cause O(n) time for a single calculation
     * we can store the path length result to hash table as memo
     * so next time when we calculate the longest path, we can retrieve it from O(1) time
     * Time: O(n)
     * Space: O(n)
     */
    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int diameterOfBinaryTree2(TreeNode root){
        if (root == null) return 0;
        int leftPath = longestPathToLeaf(root.left);
        int rightPath =  longestPathToLeaf(root.right);
        int largestChildDiameter = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(leftPath + rightPath, largestChildDiameter);
    }

    public int longestPathToLeaf2(TreeNode root){
        if (root == null) return 0;
        Integer mem = memo.get(root);
        if (mem != null) return mem;
        int result = 1 + Math.max(longestPathToLeaf(root.left), longestPathToLeaf(root.right));
        memo.put(root, result);
        return result;
    }


}
