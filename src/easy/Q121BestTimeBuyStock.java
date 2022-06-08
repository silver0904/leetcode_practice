package easy;

public class Q121BestTimeBuyStock {
    /**
     * BF method
     * Time: O(n^2)
     * Space: O(1)
     * @param prices
     * @return
     */
    public int maxProfitBF(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0;
        for (int i=0; i< prices.length-1 ; i++ ){
            for (int j=i+1; j<prices.length; j++){
                max = prices[j] - prices[i] > max ? prices[j] - prices[i] : max;
            }
        }
        return max;
    }

    /**
     * For the given time t, the max profit of t is current price -  minimum price upon t
     * So we just need to iterate all t to and get the highest profit of among t.
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE; // buying point;
        int maxProfit = 0;

        for (int i=0; i< prices.length; i++){
            int price = prices[i];
            if (price < bp) {
                bp = price;
            }
            if (price - bp > maxProfit){
                maxProfit = price - bp;
            }
        }
        return maxProfit;
    }
}
