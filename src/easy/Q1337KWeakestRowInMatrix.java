package easy;

import java.util.*;

public class Q1337KWeakestRowInMatrix {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] answer = new int[k];
        Queue<int[]> queue = new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0;i<mat.length;i++) {
            queue.offer(new int[]{Arrays.stream(mat[i]).sum(),i});
        }
        for(int i=0;i<k;i++) {
            answer[i] = queue.poll()[1];
        }

        List<int[]> list = new LinkedList<>(queue);
        return answer;

    }
}
