package easy;

import dataStructure.TreeNode;

public class Q100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // case 1: both of them are empty node
        if (p== null && q == null){
            return true;
        }
        // case 2: one of them are empty, but the one is not
        else if ( p == null || q == null){
            return false;
        }
        // case 3: both of them are not empty
        else{
            if ( p.val != q.val){
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
