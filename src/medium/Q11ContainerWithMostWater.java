package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q11ContainerWithMostWater {
    /**
     * two pointer approach
     * Time: O(n)
     * Space: O(1)
     */
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start != end){
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(maxArea, area);
            if (height[start] < height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return maxArea;
    }
}
