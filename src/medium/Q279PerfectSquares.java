package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q279PerfectSquares {
    public int numSquaresBFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int height = 0;
        while(!queue.isEmpty()){
            int qLen = queue.size();
            for (int i=0; i<qLen; i++){
                int num = queue.poll();
                if (num < 0){
                    continue;
                }
                else if (num == 0){
                    return height;
                }
                else{
                    int j=1;
                    while(num >= j*j){
                        queue.offer(num - j*j);
                        j++;
                    }
                }
            }
            height++;
        }
        return height;
    }

    public int numSquaresDP(int n) {
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            int num = i+1;
            Double sqrt = Math.sqrt(num);
            if (sqrt - sqrt.intValue() == 0) {
                dp[i] = 1;
            }
            else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[n-1];
    }


}
