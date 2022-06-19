package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q113PathSumII {
    /**
     * DFS approach
     * Tim: O(
     *
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        // reached leaf node
        if (root.left == null && root.right == null){
            if (root.val == targetSum){
                List<Integer> path = new LinkedList<>();
                path.add(root.val);
                result.add(path);
                return result;
            }
            else{
                return new LinkedList<>();
            }
        }
        else{
            List<List<Integer>> leftPaths = pathSum(root.left, targetSum - root.val);
            List<List<Integer>> rightPaths = pathSum(root.right, targetSum - root.val);
            result.addAll(leftPaths);
            result.addAll(rightPaths);
            for (List<Integer> paths : result){
                paths.add(0, root.val);
            }
            return result;
        }


    }
}
