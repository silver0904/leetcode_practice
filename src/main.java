import algorithm.BubbleSort;
import algorithm.MergeSort;
import algorithm.QuickSort;
import algorithm.Sort;
import amazon.RandomBehavioralQuestion;
import easy.*;
import medium.*;

import java.util.*;

public class main {
    public static void main (String arg[]){
        //System.out.println(RandomBehavioralQuestion.pickQuestion());
        int limit = 100000;
        int[] arr = new int[limit];
        for (int i=0; i<limit; i++){
            arr[i] = new Random().nextInt(limit);
        }

        Sort sort = new QuickSort();
        long startTime = System.currentTimeMillis();
        sort.sort(arr);
        long endTime = System.currentTimeMillis();


        for (int num : arr){
            //System.out.print(num+",");
        }
        System.out.println("Execution Time: " + Long.toString(endTime-startTime) + "ms");
        return;
    }

}
