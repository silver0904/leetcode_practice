package medium;

public class Q33SearchInRotatedSortedArray {
    /**
     * Divide and conquer approach
     * Basically 3 cases we need to consider
     * Case 1: No pivot (The list already in sequential order).
     * > 0,1,2,M,4,5,6
     * Case 2: Pivot exist, and it is before middle point.
     * > 5,6,0,M,2,3,4
     * Case 3: Pivot exist, and it is after middle point.
     * > 2,3,4,M,6,0,1
     *
     * For case 1 is simple, just follow normal Binary Search approach
     *
     * For case 2, aware that right side is sequential,
     * so if nums[M] < target <= nums[end], search the right side, else search the left side.
     *
     * For case 3, similar to case 2, the left side is sequential
     * if nums[start] <= target < nums[mid], search the left side, else search the right side.
     */
    public static int search(int[] nums, int target) {
        return search(0, nums.length, nums, target);
    }

    private static int search(int start, int end, int[] nums, int target){
        if (start == end && nums[start] != target) return -1;
        int mid = (end + start) / 2;
        if (nums[mid] == target) return mid;
        if (nums[start] < nums[end-1] ){
            // no pivot in between
            if (target < nums[mid]){
                return search(start, mid, nums, target);
            }
            else{
                return search(mid, end, nums, target);
            }
        }else{
            // pivot between start and mid
            if (nums[mid] > nums[end-1]){
                // sequential part is on the left
                return (target < nums[mid] && target >= nums[start]) ?
                        search(start, mid, nums, target) : search(mid, end, nums, target);
            } else {
                // sequential part is on the right
                return (target > nums[mid] && target <= nums[end-1]) ?
                        search(mid, end, nums, target) : search(start, mid, nums, target);
            }
        }

    }
}
