package easy;

public class Q1342StepsToZero {
    public static int numberOfSteps(int num) {
        int ans = 0;
        while(num > 0){
            ans++;
            num = num % 2 == 0 ? num/2 : num-1 ;
        }
        return ans;
    }
}
