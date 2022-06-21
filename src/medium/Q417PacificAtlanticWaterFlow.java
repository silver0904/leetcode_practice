package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q417PacificAtlanticWaterFlow {
    private HashMap<String, Boolean> pacificMap = new HashMap<>();
    private HashMap<String, Boolean> atlanticMap = new HashMap<>();

    private static final int[][] pacificDirections = new int[][]{{-1,0}, {0,-1}};
    private static final int[][] atlanticDirections = new int[][]{{1,0}, {0,1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row=0; row< heights.length; row++){
            for (int col=0; col<heights[0].length; col++){
                int[] pos = new int[]{row, col};
                int height = heights[row][col];
                if (canReachPacific(heights, pos, height) && canReachAtlantic(heights, pos, height)){
                    result.add(List.of(row, col));
                }
            }
        }
        return result;


    }

    private boolean canReachPacific(int[][] heights, int[]pos, int maxHeight){
        if (pos[0] < 0 || pos[1] < 0){
            return true;
        }
        int curHeight = heights[pos[0]][pos[1]];
        if (curHeight > maxHeight){
            return false;
        }

        Boolean cache = pacificMap.get(pos[0]+","+pos[1]);
        if (cache != null) return cache;


        boolean canReach = false;
        for (int[] dir : pacificDirections){
            canReach = canReach || canReachPacific(heights, new int[]{pos[0]+ dir[0], pos[1]+dir[1]}, curHeight);
        }
        pacificMap.put(pos[0]+","+pos[1], canReach);
        return canReach;

    }

    private boolean canReachAtlantic(int[][] heights, int[]pos, int maxHeight){
        if (pos[0] >= heights.length || pos[1] >= heights[0].length){
            return true;
        }
        int curHeight = heights[pos[0]][pos[1]];
        if (curHeight > maxHeight){
            return false;
        }

        Boolean cache = atlanticMap.get(pos[0]+","+pos[1]);
        if (cache != null) return cache;


        boolean canReach = false;
        for (int[] dir : atlanticDirections){
            canReach = canReach || canReachAtlantic(heights, new int[]{pos[0]+ dir[0], pos[1]+dir[1]}, curHeight);
        }
        atlanticMap.put(pos[0]+","+pos[1], canReach);
        return canReach;

    }
}
