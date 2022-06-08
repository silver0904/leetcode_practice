package easy;

import java.util.Arrays;

public class Q704BinarySearch {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return search(nums, 0, nums.length, target);
    }

    private static int search(int[] nums, int start, int end, int target){
        if (start == end) return -1;
        int half = (start + end) /2;
        if (nums[half] == target) {
            return half;
        }
        else if (nums[half] < target) {
            return search(nums, half+1, end, target);
        }
        else {
            return search(nums, start, half, target);
        }
    }

}
