package hard;

import dataStructure.TreeNode;

public class Q124BinaryTreeMaxPathSum_Review {
    // to maintain the actual maximum sum of path
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        path(root);
        return max;
    }

    private int path(TreeNode node) {
        // base case
        if(node == null) {
            return 0;
        }

        // traverse left and right subtrees
        int left = path(node.left);
        int right = path(node.right);

        // get the best of left subtree + current node's val vs. right subtree + current node's val vs. current node's val
        // as this value will ensure either of the path (left, right or just from the current node itself but not both the children)
        // we return this to the parent
        int leftOrRightOrCurrent =
                Math.max(Math.max(left + node.val, right + node.val), node.val);

        // maximum of current node's val vs. all the above possibilities to see if this is actually the max path?
        // best max path upto this node is this (localMaxima)
        int localMaxima = Math.max(left + right + node.val, leftOrRightOrCurrent);

        // overall maximum
        // compare the localMaxima with overall tree's max value, this will be our answer
        max = Math.max(localMaxima, max);

        // return to parent as discussed earlier
        return leftOrRightOrCurrent;
    }


}
