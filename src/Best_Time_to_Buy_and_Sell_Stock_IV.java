/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

//DP
public class Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        int size = prices.length;
        int result=0;
        if(k>=size){
            for(int i=0;i<size-1;i++){
                if(prices[i+1]>prices[i]){
                    result += prices[i+1] - prices[i];
                }
            }
            return result;
        }

        int dp[][] = new int[k+1][size];
        for(int i=1;i<=k;i++){
            int temMax = -prices[0];
            for(int j=1;j<size;j++){
                //最大利润是以j价格抛出还是持有
                dp[i][j] = Math.max(dp[i][j-1],temMax+prices[j]);
                //上一次交易完成然后以j价格买入，还是保持不变（之前买入的更便宜），for the next loop
                temMax = Math.max(dp[i-1][j-1]-prices[j],temMax);
            }
        }
        //返回终点
        return dp[k][size-1];
    }
}
