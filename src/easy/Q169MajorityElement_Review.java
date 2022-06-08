package easy;

import java.util.HashMap;
import java.util.Map;

public class Q169MajorityElement_Review {
    /**
     * Hash Table Approach
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            Integer num = hashMap.get(nums[i]);
            hashMap.put(nums[i], num == null ? 1: num+1);
        }
        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if (entry.getValue() > nums.length/2) return entry.getKey();
        }
        return -1;
    }

    /**
     * Boyer-Moore's algorithm
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int maj = nums[0];
        int count = 1;
        for (int i=1; i< nums.length; i++){
            if (nums[i] != maj){
                --count;
                if (count < 0){
                    maj = nums[i];
                    count = 1;
                }
            }
            else{
                count++;
            }
        }
        return maj;
    }
}