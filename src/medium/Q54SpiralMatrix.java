package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q54SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int x = matrix[0].length, y = matrix.length;
        int count = 0;
        while (x>0 && y>0){
            result.addAll(traverse(matrix, new int[]{count, count},new int[]{x,y}));
            x -=2;
            y -=2;
            count++;
        }
        return result;
    }

    public static List<Integer> traverse(int[][] matrix, int[] startPoint, int[]dimension){
        if (dimension[0] <= 0 && dimension[1] <= 0) return new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        for(int i=0; i<dimension[0]; i++){
            int x = startPoint[0]+i;
            int y = startPoint[1];
            list.add(matrix[y][x]);
        }
        for(int j=1; j<dimension[1]; j++){
            int x = startPoint[0] + dimension[0] -1;
            int y = startPoint[1] + j;
            list.add(matrix[y][x]);
        }
        if (dimension[0] == 1 || dimension[1] == 1)return list;
        for(int k= 1; k < dimension[0]; k++){
            int x = startPoint[0] + dimension[0] - 1 - k;
            int y = startPoint[1] + dimension[1] - 1;
            list.add(matrix[y][x]);
        }
        for(int l= 1; l < dimension[1]-1; l++){
            int x = startPoint[0];
            int y = startPoint[1] + dimension[1] -1 -l;
            list.add(matrix[y][x]);
        }
        return list;
    }
}
