package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q416PartitionEqualSubsetSum {
    /**
     * DP Approach
     * Time: O(sum(nums))
     * Space: O(sum(nums))
     */
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum %2 != 0) return false;
        int target = sum/2;
        Set<Integer> sumSet = new HashSet<>();
        for (int num: nums){
            if (sumSet.isEmpty()){
                sumSet.add(0);
                sumSet.add(num);
            }else{
                Set<Integer> newSet = new HashSet<>();
                for (Integer prevSum : sumSet){
                    int newSum = prevSum + num;
                    if (newSum == target) return true;
                    newSet.add(newSum);
                }
                sumSet.addAll(newSet);
            }
        }
        return false;

    }
}
