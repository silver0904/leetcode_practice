package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2FindSum {
    static boolean findSumOfTwo(int[] A, int val) {
        Set<Integer> integerSet = new HashSet<>();

        for (int a : A){
            if (integerSet.contains(val -a)){
                return true;
            }
            integerSet.add(a);
        }
        return false;
    }
}
