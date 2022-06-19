package amazon;

import java.util.List;

public class Q1FindMissingNumber {
    static int find_missing(List<Integer> input) {

        int expectedSum = 0;
        for (int i=1; i<= input.size() + 1; i++){
            expectedSum += i;
        }

        int currentSum = 0;
        for (Integer value : input){
            currentSum += value;
        }
        return expectedSum - currentSum;

    }
}
