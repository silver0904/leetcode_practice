package medium;

import java.util.ArrayList;
import java.util.List;

public class Q300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<int[]> dp = new ArrayList<>(); //int[0] = num value, int[1] = length of sequence
        int maxLength = 0;
        for (int i=0; i< nums.length; i++){
            int val = nums[i];
            int pastMaxLength = 0;
            for (int[] pastResult: dp){
                if (pastResult[0] >= val) continue;
                pastMaxLength = Math.max(pastMaxLength, pastResult[1]);
            }
            maxLength = Math.max(maxLength, pastMaxLength +1);
            dp.add(new int[]{val, pastMaxLength +1});
        }
        return maxLength;
    }

    /**
     * real dp solution
     */
    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        for (int i=nums.length-1; i>=0; i--){
            if(i == nums.length-1){
                dp[i] = 1;
            }
            int max = 1;
            for (int j=i+1; j<nums.length-1; j++){
                if (nums[j] <= nums[i]){
                    continue;
                }
                max = Math.max(max, dp[j] +1);
            }
            dp[i] = max;
            maxLength = Math.max(maxLength, max);
        }
        for (int num : dp){
            System.out.print(num +",");
        }

        return maxLength;

    }
}
