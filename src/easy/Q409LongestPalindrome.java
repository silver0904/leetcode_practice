package easy;

public class Q409LongestPalindrome {
    /**
     * Frequency Array
     * A palindrome is constructed by following cases:
     * 1. n set of even characters
     * 2. n set of even characters, and 1 character as pivot
     * where n can be zero
     * Since character in string is limited to 'A' to 'z',
     * we can create an array with the size of 52 to store all character count inside the string
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        int[] memo = new int['z'- 'A' + 1];
        for (char c : s.toCharArray()){
            memo['z' - c] = ++memo['z' -c];
        }
        boolean hasPivot = false;
        int palindromeCharCount = 0;
        for (int i=0; i< memo.length; i++){
            if (memo[i] == 0) continue;
            if (memo[i] %2 == 1) {
                if (!hasPivot) hasPivot = true;
                palindromeCharCount += memo[i] -1 ;
            }
            else{
                palindromeCharCount += memo[i];
            }
        }
        return hasPivot ? palindromeCharCount +1 : palindromeCharCount;
    }
}
