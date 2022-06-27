package medium;

public class Q153FindMinimumInRotatedSortedArray {
    // 4,5,6,7,0,1,2
    // 6,7,0,1,2,4,5
    // 5,6,7,0,1,2,4
    // 0,1,2,4,5,6,7
    //    start < mid < end
    // if (end < mid) go check right side
    // if (start > mid) go check left side
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length);

    }

    public int binarySearch(int[] nums, int start, int end){
        if (start == end-1){
            return nums[start];
        }
        int mid = start + (end - 1 - start)/2;
        int val = nums[mid];

        if (mid !=0 && val < nums[mid-1]){
            return val;
        }

        if (nums[end-1] < val){
            return binarySearch(nums, mid+1, end);
        }else if(nums[start] > val){
            return binarySearch(nums, start, mid);
        }

        return nums[start];

    }
}
