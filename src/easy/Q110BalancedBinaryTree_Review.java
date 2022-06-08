package easy;

import dataStructure.TreeNode;

public class Q110BalancedBinaryTree_Review {
    int height(TreeNode root){
        if(root==null)
            return 0;
        int lHeight=height(root.left);
        int rHeight=height(root.right);
        return Math.max(lHeight,rHeight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        int lHeight=height(root.left);
        int rHeight=height(root.right);

        int balenceFactor=Math.abs(lHeight-rHeight);
        if(balenceFactor>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
}
