package medium;

import java.util.*;

public class Q8StringToInteger {

    public static int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i == s.length()) return 0;

        int sign = 1;
        int num = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') sign =
                s.charAt(i++) == '-' ? -1 : 1;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (
                    num > Integer.MAX_VALUE / 10 ||
                            (num * 10 > Integer.MAX_VALUE - (s.charAt(i) - '0'))
            ) {
                // if digit is 8,9 and sign is +, return MAX_VALUE
                // if digit is 8,9 and sign is -, return min (8 is valid, but the value is the same as MIN_VALUE)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = 10 * num + (s.charAt(i++) - '0');
        }
        return num * sign;
    }
}
