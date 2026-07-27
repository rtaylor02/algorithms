package oreilly.liveevents.rohitbhardwaj.algorithms.arrays;

public class BestTimeToBuyAndSellStock {

    public int calculateMaxProfit(int[] prices) {
        int buyPrice = prices[0];
        int currentProfit = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            currentProfit = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}
