import easy.*;
import medium.*;

import java.util.*;

public class main {
    public static void main (String arg[]){
        System.out.println(Q300LongestIncreasingSubsequence.lengthOfLIS2(
                new int[]{0,1,0,3,2,3}
        ));
        Set<String>[] dp = new HashSet[10];
        dp[0]= Set.of("()");

        //System.out.println(test.minimalHeaviestSetA(new ArrayList<>(List.of(5,3,2,4,1,2))));
        return;
    }

}
