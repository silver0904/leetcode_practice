package easy;

import java.util.ArrayList;

public class Q70ClimbStair {
    /**
     * Brute force
     * Think it as a Binary Tree, start the root node as 0 and add 2 child nodes by 1 and 2
     * The route count would be the count of leaf node that reaches target number
     * Say target is 3
     *              0
     *            /    \
     *           1      2
     *         /  \    /
     *        2    3  3
     *      /
     *     3
     * The num leaf node that reaches 3 is 3, so answer is 3
     * Time: O(2^n) where n is the depth of the tree and the target value
     * Space: O(1)
     * @param n
     * @return
     */
    public static int climbStairsBF(int n) {
        if (n == 0) return 0;
        return climbStairsBF(0, n);
    }

    public static int climbStairsBF(int current, int target){
        if (current > target) {
            return 0;
        }
        if (current == target) {
            return 1;
        }
        return climbStairsBF(current + 1, target) + climbStairsBF(current + 2, target);
    }


    /**
     * Dynamic Programming Approach
     *              0
     *            /    \
     *           1      2
     *         /  \    /
     *        2    3  3
     *      /
     *     3
     * If we use previous example, some part of the tree is duplicated,
     * we can store the climbStair(k) result in a memo
     * and retrieve it when necessary to avoid calculating duplicated parts.
     * Time: O(n) - when calculating the left most route, all possible result is stored
     * Space: O(n) - memo
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if (n == 0) return 0;
        int[] memo = new int[n+1];
        return climbStairs(0, n, memo);
    }

    public static int climbStairs(int current, int target, int[] memo){
        if (current > target) {
            return 0;
        }
        if (memo[current] != 0) {
            return memo[current];
        }
        if (current == target) {
            return 1;
        }
        int result = climbStairs(current + 1, target, memo) + climbStairs(current + 2, target, memo);
        memo[current] = result;
        return result;
    }
}
