package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q56MergeIntervals {

    /**
     * Time: O(nlog(n) + n) sorting + iteration
     * Space: O(n) storing result only
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[] cur = intervals[0];
        List<int[]> result = new LinkedList<>();


        for (int i=1; i< intervals.length; i++){
            if (cur[1] < intervals[i][0]){
                result.add(cur);
                cur = intervals[i];
            }else{
                cur[1] = Math.max(intervals[i][1], cur[1]);
            }
        }
        result.add(cur);

        return result.toArray(new int[result.size()][2]);
    }
}
