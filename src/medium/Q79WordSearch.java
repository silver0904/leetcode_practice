package medium;

import java.util.HashSet;
import java.util.Set;

class Q79WordSearch {
    private static final int[][] directions = new int[][]{
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    public boolean exist(char[][] board, String word) {
        boolean exist = false;
        for (int i=0; i< board.length; i++){
            for (int j=0; j< board[0].length; j++){
                if (exist)return true;
                exist = exist || dfs(word, 0, board, i,j);
            }
        }
        return exist;

    }

    private boolean dfs(String word, int pos, char[][] board, int row, int col){
        if (pos == word.length()) {
            return true;
        }
        if (!isInBound(row, col, board)){
            return false;
        }
        if (board[row][col] == word.charAt(pos)){
            char cur = board[row][col];
            board[row][col] = 0;
            boolean exist = false;
            for (int[] dir : directions){
                exist = exist || dfs(word, pos +1, board, row+dir[0], col+dir[1]);
            }
            board[row][col] = cur;
            return exist;
        }

        return false;
    }

    private boolean isInBound(int row, int col, char[][] board){
        return (col >= 0 && col < board[0].length && row >= 0 && row < board.length);
    }
}