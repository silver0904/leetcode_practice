package easy;

public class Q88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int finalIdx = m+n -1;

        while (m>= 1 && n>= 1){
            if (nums2[n-1] > nums1[m-1]){
                nums1[finalIdx] = nums2[n-1];
                n--;
            }else{
                nums1[finalIdx] = nums1[m-1];
                nums1[m-1] = 0;
                m--;
            }
            finalIdx--;
        }

        while (n>0 && finalIdx >=0){
            nums1[finalIdx] = nums2[n-1];
            n--;
            finalIdx--;
        }
    }
}
