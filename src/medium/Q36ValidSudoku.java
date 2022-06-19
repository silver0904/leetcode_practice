package medium;

import java.util.HashSet;
import java.util.Set;

public class Q36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rowSetArr = new HashSet[9];
        Set<Integer>[] colSetArr = new HashSet[9];
        Set<Integer>[][] gridSetArr = new HashSet[3][3];

        for (int row=0; row<9; row++){
            rowSetArr[row] = new HashSet<>();
            for(int col=0; col<9; col++){
                if (row == 0){
                    colSetArr[col] = new HashSet<>();
                }
                if (row %3 == 0 && col% 3 == 0){
                    gridSetArr[row/3][col/3] = new HashSet<>();
                }
                int val = board[row][col] - '.';
                if (val == 0) continue;

                Set<Integer> rowSet = rowSetArr[row];
                Set<Integer> colSet = colSetArr[col];
                Set<Integer> gridSet = gridSetArr[row/3][col/3];


                if (rowSet.contains(val) || colSet.contains(val) || gridSet.contains(val)){
                    return false;
                }

                rowSet.add(val);
                colSet.add(val);
                gridSet.add(val);

            }
        }
        return true;
    }
}
