package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q46Permutations {
    /**
     *  DFS approach
     *  Time: O(n^n)
     *  Space: O(1)
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new LinkedList<>();
        dfs(new LinkedList<>(), Arrays.stream(nums).boxed().collect(Collectors.toList()), result);
        return result;
    }

    public static void dfs(List<Integer> cur, List<Integer> opt, List<List<Integer>> result){
        if (opt.isEmpty()) {
            result.add(cur);
            return;
        }
        for (int i=0; i< opt.size(); i++){
            List<Integer> newCur = new LinkedList<>(cur);
            newCur.add(opt.get(i));
            List<Integer> newOpt = new LinkedList<>(opt.subList(0,i));
            if (i != opt.size()-1){
                newOpt.addAll(opt.subList(i+1, opt.size()));
            }
            dfs(newCur, newOpt, result);
        }

    }
}
