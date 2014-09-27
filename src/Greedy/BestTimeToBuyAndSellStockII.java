package Greedy;

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
        int sum = 0;
        if(null == prices || prices.length < 2) {
            return sum;
        }

        for(int i = 1; i < prices.length; i ++) {
            int profit = prices[i] - prices[i - 1];

            if(profit > 0) {
                sum += profit;
            }
        }
        return sum;
    }
}
