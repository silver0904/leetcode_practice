package medium;

import java.util.Stack;

public class Q739DailyTemperatures {
    private class DayTemperature{
        public int day;
        public int temperature;
        public DayTemperature(int day, int temperature){
            this.day = day;
            this.temperature = temperature;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<DayTemperature> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i= temperatures.length-1; i>= 0; i--){

            int warmestTemperature = 0;
            int currentTemperature = temperatures[i];
            while(currentTemperature >= warmestTemperature){
                if (stack.isEmpty()){
                    result[i] = 0;
                    stack.push(new DayTemperature(i, currentTemperature));
                    break;
                }
                DayTemperature nextWarmDay = stack.peek();
                warmestTemperature = nextWarmDay.temperature;
                if (currentTemperature >= warmestTemperature){
                    stack.pop();
                }
                else{
                    result[i] = nextWarmDay.day - i;
                    stack.push(new DayTemperature(i, currentTemperature));
                }
            }

        }
        return result;
    }

}
