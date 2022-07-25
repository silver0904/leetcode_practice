package algorithm;

public class MergeSort implements Sort{
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    public void mergeSort(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = (left + right)/2;
//        System.out.println(left +"," + right);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    void merge(int arr[], int left, int mid, int right)
    {
        // Find sizes of two subarrays to be merged
        int leftLen = mid - left + 1;
        int rightLen = right - mid;

        /* Create temp arrays */
        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        /*Copy data to temp arrays*/
        for (int i = 0; i < leftLen; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < rightLen; ++j)
            rightArr[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < leftLen && j < rightLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < leftLen) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        /* Copy remaining elements of rightArr[] if any */
        while (j < rightLen) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
