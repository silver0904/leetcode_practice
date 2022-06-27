package medium;

public class Q198HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[2];

        for (int i=0; i< nums.length; i++){
            dp[i%2] = Math.max(dp[i%2] + nums[i], dp[Math.abs(i-1)%2]);
        }

        return dp[(nums.length-1) %2];
    }
}
