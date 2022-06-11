package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q39CombinationSum {

    /**
     * DP approach
     * Time: O(T*c^2)
     * Space: O(T*c^2)
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] memo = new LinkedList[target+1];
        Arrays.sort(candidates);

        for (int i=0; i<= target; i++){
            memo[i] = new LinkedList<>();


            for (int candidate : candidates){
                if (candidate > i) continue;

                if (candidate == i){
                    memo[i].add(Arrays.asList(candidate));
                }
                else if (memo[i-candidate] != null){
                    List<List<Integer>> prevList = memo[i-candidate];

                    for (List<Integer> subList: prevList){
                        if(candidate >= subList.get(subList.size()-1)) {
                            List<Integer> newList = new LinkedList<>(subList);
                            newList.add(candidate);
                            memo[i].add(newList);
                        }
                    }
                }

            }
        }
        return memo[target];
    }
}
