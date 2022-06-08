package medium;

import java.util.*;

public class Q15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> al = new ArrayList();
        Arrays.sort(nums);

        int n = nums.length;
        for(int i=0; i<n-1; i++){
            int j=i+1; int k=n-1;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            while(k>j){
                if(k<n-1 && nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                if(nums[j]+nums[k]==-nums[i]){
                    al.add(List.of(nums[i],nums[j],nums[k]));
                }
                if(nums[j]+nums[k]>=-nums[i])
                    k--;
                else
                    j++;
            }
        }

        return al;
    }
}
