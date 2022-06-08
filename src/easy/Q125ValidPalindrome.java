package easy;

public class Q125ValidPalindrome {
    /**
     * first remove all the non-alphanumeric character from the string
     * then check traverse character the pointer from right and left side to middle
     * to check if all pairs of the character are matched.
     * Time: O(n)
     * Space: O(1)
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z\\d]", "").toLowerCase();
        for (int i=0; i< s.length(); i++){
            if (i >= s.length()/2  ) {
                return true;
            }
            if (s.length()%2 == 1 && i == s.length()-1){
                return true;
            }
            if (s.charAt(i) != s.charAt(s.length()- i -1)){
                return false;
            }
        }
        return true;
    }


}
