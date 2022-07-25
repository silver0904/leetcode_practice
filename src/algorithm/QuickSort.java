package algorithm;

import java.util.Random;

public class QuickSort implements Sort {
    public void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    public void quickSort(int[] arr, int left, int right){
        if (left >= right) return ;
        int pPos = partition(arr,left, right);
        quickSort(arr, left, pPos-1);
        quickSort(arr, pPos+1, right);

    }

    public int partition(int[] arr, int left, int right){
        int pIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = arr[pIndex];

        int pPos = left;
        swap(arr, right, pIndex);
        for (int i=left; i<right; i++){
            if (arr[i] <= pivot){
                swap(arr, i, pPos);
                pPos++;
            }
        }
        swap(arr, right, pPos);
        return pPos;

    }

    public void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
