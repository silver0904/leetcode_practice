package medium;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Vector;

public class Q542_01Matrix {
    /**
     * Approach: Start from zero(s)
     * Step 1:
     * We first find all the 0 point in the matrix, and put the position inside a queue.
     * If non-zero point is found, we mark its distance to infinite.
     * Step 2:
     * Then we iterate the queue which store all the zero position,
     * and find if any non-zero point is adjacent to it.
     * If so, mark distance to 0 of that adjacent point to 1 + 0
     * and put that calculated point to the queue.
     * Step 3:
     * We keep doing step 2 until all the point of the matrix is calculated.
     *
     */
    public static int[][] updateMatrix(int[][] mat) {
        int[][] memo = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i=0; i< mat.length; i++){
            for (int j=0; j< mat[i].length; j++){
                if (mat[i][j] == 0){
                    memo[i][j] = 0;
                    queue.offer(new int[]{i,j});
                }else{
                    memo[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] curPos = queue.poll();
            int[][] posToCheck = new int[][]{
                    new int[]{curPos[0]-1, curPos[1]},
                    new int[]{curPos[0]+1, curPos[1]},
                    new int[]{curPos[0], curPos[1]-1},
                    new int[]{curPos[0], curPos[1]+1},
            };
            for (int[] pos : posToCheck){
                if (pos[0] < 0 || pos[0] >= mat.length || pos[1] <0 || pos[1] >= mat[0].length){
                    continue;
                }
                if (1+ memo[curPos[0]][curPos[1]] < memo[pos[0]][pos[1]] ){
                    memo[pos[0]][pos[1]] = 1+ memo[curPos[0]][curPos[1]];
                    queue.offer(new int[]{pos[0], pos[1]});
                }
            }
        }
        return memo;
    }
}
