package easy;

public class Q9PalidromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int digits = (int)Math.log10(x) ;

        if (digits == 0) return true;
        int head = digits; int tail = 0;
        while(head > tail){
            int first = x / (int)Math.pow(10, head) % 10;
            int last = (x / (int)Math.pow(10, tail)) % 10;
            if (first != last) return false;
            head --;
            tail ++;
        }
        return true;
    }
}
