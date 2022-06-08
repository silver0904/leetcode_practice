package easy;

public class Q67AddBinary {
    /**
     *     10
     *  + 1 0
     *  0
     */
    public static String addBinary(String a, String b) {
        StringBuilder ans = new  StringBuilder();
        int aLength = a.length() ;
        int bLength = b.length() ;
        int index = 0;
        int carry = 0;
        while (index< aLength || index< bLength || carry != 0){
            int x = index < aLength && a.charAt(aLength - index -1) == '1' ? 1 : 0;
            int y = index < bLength && b.charAt(bLength - index -1) == '1' ? 1 : 0;
            int result = x + y + carry;
            carry = 0;
            if (result > 1) {
                result = result % 2;
                carry = 1;
            }
            ans.append(result);
            index++;
        }
        return ans.reverse().toString();

    }
}
