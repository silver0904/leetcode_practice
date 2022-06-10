package medium;

import java.util.*;

public class Q200NumberOfIslands {
    static final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0,1}, {0, -1}};

    /**
     *
     * BFS approach
     * Time: O(mn) where m is row, n is col
     * Space: O(
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) { //corner case check
            return 0;
        }

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private static void bfs(char[][] grid, int r, int c) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(r,c));
        grid[r][c] = '0';

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();

            for (int[] dir : directions) {
                int rIndex = cur.get(0) + dir[0];
                int cIndex = cur.get(1) + dir[1];

                if (isValid(rIndex, cIndex, grid)) {
                    queue.offer(Arrays.asList(rIndex, cIndex));
                    grid[rIndex][cIndex] = '0';
                }

            }
        }

    }

    private static boolean isValid(int i, int j, char[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && grid[i][j] == '1';
    }
}
