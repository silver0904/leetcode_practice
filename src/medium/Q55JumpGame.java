package medium;

public class Q55JumpGame {
    /**
     *
     * Time: O(n^2)
     * Space: O(n)
     */
    public boolean canJumpDp(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        dp[nums.length-1] = true;
        for (int i=nums.length-2; i>= 0; i--){
            int num = nums[i];
            if (num == 0){
                dp[i] = false;
                continue;
            }
            for (int j=1; j< num+1 ; j++){
                if (j+i == nums.length - 1) {
                    dp[i] = true;
                }else{
                    dp[i] = dp[i] || dp[j+i];
                }
            }
        }

        return dp[0];
    }

    /**
     * Greedy
     * Time O(n)
     * Space: O(1)
     */
    public boolean canJump(int[] nums) {
        int last = nums.length-1;

        for (int i=nums.length-2; i>= 0; i--){
            if (nums[i] + i >= last){
                last = i;
            }
        }

        return last == 0;
    }
}
