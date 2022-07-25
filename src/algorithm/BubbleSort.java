package algorithm;

public class BubbleSort implements Sort{
    @Override
    public void sort(int[] arr) {
        for (int i=1; i<arr.length; i++){
            for (int j=0; j<arr.length-1; j++){
                if (arr[j] > arr[j+1] ){
                    swap(arr,j+1,j);
                }
            }
        }
    }

    public void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
