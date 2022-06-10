package medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Q994RottingOranges {
    private static Integer[][] directions = new Integer[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for (int i=0; i< grid.length; i++){
            for (int j=0; j< grid[i].length; j++){
                if (grid[i][j] == 2) queue.add(new Integer[]{i,j});
                if (grid[i][j] == 1) freshCount++;
            }
        }
        if (freshCount == 0) return 0;
        int minutes = 0;
        while (!queue.isEmpty()){
            int qLen = queue.size();
            for (int i = 0; i< qLen; i++){
                Integer[] pos = queue.poll();
                for (Integer[] dir : directions) {
                    Integer[] newPos = new Integer[]{pos[0] + dir[0], pos[1] + dir[1]};
                    if (isValid(newPos[0], newPos[1], grid)) {
                        grid[newPos[0]][newPos[1]] = 2;
                        freshCount--;
                        queue.offer(newPos);
                    }
                }
            }
            minutes++;
        }

        return freshCount == 0? minutes : -1;

    }

    private static boolean isValid(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && grid[i][j] == 1;
    }
}
