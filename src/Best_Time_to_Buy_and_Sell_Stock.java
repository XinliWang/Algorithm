/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

/**
 * 1.当数组递减，则无论什么时候买都会亏本，则不买，利润为0
 * 2.每次两数比较，如果后面的数大则比较求利润，如果后面的数小则把当前买的先赋予给它，因为更有可能得到更大的利润
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices){
        int size = prices.length;
        if(size==0)return 0;
        int profit=0;
        int index=0;
        int stock = prices[0];
        for(int i=1;i<size;i++){
            index = prices[i];
            if(stock<=index){
                profit = Math.max(profit,index-stock);
            }else{
                stock = index;
            }
        }
        return profit;
    }
}
