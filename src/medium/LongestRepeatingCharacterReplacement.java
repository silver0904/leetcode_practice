package medium;

import java.util.LinkedList;
import java.util.Queue;

public class LongestRepeatingCharacterReplacement {
    /**
     *
     * Optimized Brute Force
     * Time O(n^2)
     * Space: O(n)
     */
    public int characterReplacement(String s, int k) {
        Queue<Integer> queue = new LinkedList<>();
        char[] charArr = s.toCharArray();
        int max = 0;

        queue.offer(0);
        while (!queue.isEmpty()){
            int idx = queue.poll();
            char curChar = charArr[idx];
            int replaceCount = k;
            int length = 1;
            for (int i = idx+1; i< charArr.length; i++){
                char ch = charArr[i];
                if (curChar != ch){
                    queue.offer(i);
                    if (replaceCount == 0){
                        break;
                    }
                    replaceCount--;
                }
                length++;
            }
            int localMax = replaceCount == 0? length : Math.min(charArr.length, length + replaceCount);

            max = Math.max(localMax, max);
        }

        return max;
    }

    /**
     * Sliding Window
     * Time: O(n)
     * Space: O(n) (can be optimized to O(1) if not assign variable)
     */
    public int characterReplacementSW(String s, int k) {
        char[] charArr = s.toCharArray();
        int max = 0;

        int leftIdx = 0;
        int rightIdx = 0;
        int[] charCount = new int[26];

        while (rightIdx < charArr.length){

            char ch = charArr[rightIdx];
            charCount[ch - 'A']++;


            if ((rightIdx - leftIdx + 1) - maxFrequency(charCount) <= k){
                max = Math.max(rightIdx - leftIdx + 1, max);
            }else{
                while((rightIdx - leftIdx + 1) - maxFrequency(charCount) > k){
                    charCount[charArr[leftIdx] - 'A']--;
                    leftIdx++;
                }

            }
            rightIdx++;


        }
        return max;
    }

    private int maxFrequency(int[] charCount){
        int max = 0;
        for (int i=0; i< charCount.length; i++){
            max = Math.max(charCount[i], max);
        }
        return max;
    }


}
