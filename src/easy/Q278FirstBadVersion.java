package easy;

public class Q278FirstBadVersion {
    private static boolean isBadVersion(int n){return n >= 4;}

    /**
     * Brute Force Approach
     * iterate each version from the list, if find the first version is bad, return it
     * Time: O(n)
     * Space: O(1)
     * @param n
     * @return
     */
    public int firstBadVersion(int n){
        for (int i=1; i<= n; i++){
            if (isBadVersion(i)) return i;
        }
        return -1;
    }

    /**
     * divide and conquer approach
     * use binary search
     * Time: O(log n)
     * Space: O(log n)
     * @param n
     * @return
     */
    public static int firstBadVersion2(int n){
        int i=0;
        int start =1;
        int end = n;
        while(start<=end){

            int mid = start + (end-start)/2;
            if(isBadVersion(mid))
            {
                i = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return i;
    }
}
