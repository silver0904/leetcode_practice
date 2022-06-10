import easy.*;
import medium.*;

public class main {
    public static void main (String arg[]){
        System.out.println(Q200NumberOfIslands.numIslands(
                new char[][]{
                        new char[]{'1','1','1','1','0'},
                        new char[]{'1','1','0','1','0'},
                        new char[]{'1','1','0','0','0'},
                        new char[]{'0','0','0','0','0'}     
                }
        ));
        return;
    }

}
