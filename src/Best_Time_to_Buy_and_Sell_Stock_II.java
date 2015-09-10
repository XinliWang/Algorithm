/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).
 */

/**
 * 遍历一遍，每次比较取差值相加，如果较小，则赋值给stock继续比较
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int profit = 0;
        int index = 0;
        int stock = prices[0];

        for(int i=0; i< size;i++){
            index = prices[i];
            if(index>=stock){
                profit += index - stock;
            }
            stock = index;
        }
        return profit;
    }
}
