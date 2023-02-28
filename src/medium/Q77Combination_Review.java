package medium;

import java.util.ArrayList;
import java.util.List;

public class Q77Combination_Review {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(result, curr, n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int n, int k, int start) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(result, curr, n, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
