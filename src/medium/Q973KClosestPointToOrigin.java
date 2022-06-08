package medium;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Q973KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            int tmpA = (a[0]*a[0])+(a[1]*a[1]);
            int tmpB = (b[0]*b[0])+(b[1]*b[1]);
            return tmpB - tmpA;
        });

        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
            if(pq.size()>k) pq.remove();
        }

        int[][] ans = new int[k][1];
        while(!pq.isEmpty()){
            ans[--k] = pq.remove();
        }
        return ans;
    }
}
