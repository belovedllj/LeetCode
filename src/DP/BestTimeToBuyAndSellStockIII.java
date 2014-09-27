package DP;

//DP & Greedy
// k times transactions http://blog.csdn.net/linhuanmars/article/details/23236995
public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[] forward = new int[prices.length];
        forward[0] = 0;
        int profit = 0; // at most 2 transactions can be 0
        int minPri = prices[0];
        for(int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPri);
            minPri = Math.min(minPri, prices[i]);
            forward[i] = profit;
        }
        // using one array is enough
        profit = 0;
        int maxProfit = Math.max(0, forward[prices.length - 1]);
        // one transaction [0, n];
        int maxPri = prices[prices.length - 1];
        for(int j = prices.length - 2; j >= 0; j--) {
            profit = Math.max(profit, maxPri - prices[j]);
            maxPri = Math.max(maxPri, prices[j]);
            int curMaxPro = Math.max(forward[j], forward[j] + profit);
            maxProfit = Math.max(maxProfit, curMaxPro);
        }
        return maxProfit;
    }
}
