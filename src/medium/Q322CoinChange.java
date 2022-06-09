package medium;

import java.util.*;

public class Q322CoinChange {
    /**
     *  BFS approach
     *  Time: O(c^a), c is the coins size, L is the amount
     *  Space: O(n)
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;

        Queue<Integer> queue = new LinkedList<>();
        int level = 1;
        for (int c : coins){
            queue.offer(c);
        }
        while (!queue.isEmpty()){
            int qLen = queue.size();

            for (int i=0; i< qLen; i++){
                int val = queue.poll();
                if (val > amount) continue;
                if (val == amount) return level;
                for (int j=0; j< coins.length; j++){
                    queue.offer(val + coins[j]);
                }
            }
            level++;
        }
        return -1;

    }


    /**
     * DFS with DP
     */

    public static int coinChange2(int[] coins, int amount){

        Map<Integer, Integer> memo = new HashMap<>();
        return coinChangeDfsDp(coins, amount, memo);
    }
    public static int coinChangeDfsDp(int[] coins, int amount, Map<Integer, Integer> memo){
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        Integer mem = memo.get(amount);
        if (mem != null) return mem;

        int minCount = Integer.MAX_VALUE;
        for (int i=0; i< coins.length; i++){
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            else{
                int coinCount = coinChange2(coins, amount - coins[i]);
                if (coinCount != -1){
                    coinCount = 1 + coinCount;
                    minCount = Math.min(coinCount, minCount);
                }
            }
        }
        if (minCount != Integer.MAX_VALUE){
            memo.put(amount, minCount);
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;

    }

    /**
     * true DP
     * Time: O(c * a), c = coins length, a = amount
     * Space: O(a)
     */
    public static int coinChange3(int[] coins, int amount){
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;

        int[] memo = new int[amount+1];

        for(int i=0; i<= amount ; i++){
            memo[i] = Integer.MAX_VALUE;
        }

        for(int cur=0; cur<= amount ; cur++){
            for (int j=0; j< coins.length; j++){
                int coin = coins[j];
                if (cur < coin) continue;
                else if (cur == coin) {
                    memo[cur] = 1;
                }else{
                    int result = memo[cur-coins[j]] == Integer.MAX_VALUE ?
                            Integer.MAX_VALUE : 1 + memo[cur-coins[j]];
                    memo[cur] = Math.min(memo[cur], result);
                }
            }
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}
