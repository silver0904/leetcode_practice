package medium;

import java.util.ArrayList;
import java.util.List;

public class Q78Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        result.add(new ArrayList<>());
        while (count < nums.length){
            int num = nums[count];
            List<List<Integer>> currentSet = new ArrayList<>();
            for (List<Integer> list : result){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                currentSet.add(newList);
            }
            result.addAll(currentSet);
            count++;
        }
        return result;

    }
}
