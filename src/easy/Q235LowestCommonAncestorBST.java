package easy;

import dataStructure.TreeNode;

public class Q235LowestCommonAncestorBST {
    /**
     * 4 situations
     * 1. p = root || q = root, p | q is the LCA
     * 2. p > root > q || p < root < q, root is the LCA
     * 3. p and q < root, LCA is on the left side of root
     * 4. p and q > root, LCA is on the right side of root
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val){
            return p;
        }
        else if (q.val == root.val){
            return q;
        }

        if ((p.val > root.val && root.val > q.val ) || (p.val < root.val && root.val < q.val )){
            return root;
        }
        else if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
