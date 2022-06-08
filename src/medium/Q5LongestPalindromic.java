package medium;

public class Q5LongestPalindromic {
    // Time: O(n^2), Space: O(1)
    public static String longestPalindrome(String s){
        int start = 0;
        int end = 0;
        for (int i=0; i< s.length(); i++){
            int len1 = expendFromMiddle(s, i, i);
            int len2 = expendFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start ){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end +1);
    }

    private static int expendFromMiddle(String s, int left, int right){
        if (s == null || s == "" || left > right) return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }


    //Brute Force, Time: O(n^3), Space: O(n)
    public static String longestPalindromeBF(String s) {
        if (s.length() == 1) return s;
        String result = s.substring(0,1);
        for (int i=0; i<s.length()-1; i++){
            for (int j=i+1; j< s.length(); j++){
                String current = s.substring(i,j+1);
                if (isPalindromeBF(current) && result.length() < current.length()){
                    result = current;
                }
            }
        }
        return result;
    }

    private static boolean isPalindromeBF(String s){
        if (s.length() ==1) return true;

        for (int i=0 ; i< s.length()/2 ; i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
