package medium;

import java.util.Random;

public class Q215KthLargestElementInArray_Review {
    /**
     * Quick Select Algorithm
     * Time: Normal: O(n), Worst: O(n^2)
     *
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length -1, nums.length-k);
    }
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);
        if (pIndex == k){
            return nums[k];
        }
        else if (pIndex < k){
            return quickSelect(nums, pIndex+1, right, k);
        }else{
            return quickSelect(nums, left, pIndex-1, k);
        }

    }

    private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, right, pIndex);

        int pPos = left;
        for (int i=left; i< right; i++){
            if (nums[i] <= pivot){
                swap(nums, i, pPos);
                pPos++;
            }
        }
        swap(nums, pPos, right);
        return pPos;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
