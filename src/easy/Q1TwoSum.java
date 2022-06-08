package easy;

import java.util.HashMap;
import java.util.Map;

public class Q1TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            Integer matchedIndex = valueMap.get(target - nums[i]);
            if (matchedIndex != null){
                return new int[] {matchedIndex, i};
            }
            valueMap.put(nums[i], i);
        }
        return new int[] {0,0};
    }
}
