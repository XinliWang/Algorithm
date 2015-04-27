/**
 * Say you have an array for which the ith element is
 * the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete at most two transactions.

 Example
 Given an example [4,4,6,1,1,4,2,5], return 6.

 Note
 You may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).

 Tags Expand
 Enumeration Forward-Backward Traversal Array
 */
public class Best_Time_to_Buy_and_Sell_Stock3 {
    //divide and conquer
    public int maxProfit(int[]prices){
        if(prices==null||prices.length<=1){
            return 0;
        }
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] =0;
        right[n-1] = 0;
        int min = prices[0];
        for(int i=1;i<n;i++){
            min = Math.min(min,prices[i]);
            left[i] = Math.max(left[i-1],prices[i]-min);
        }
        int max = prices[n-1];
        for(int j=n-2;j>=0;j--){
            max = Math.max(prices[j],max);
            right[j] = Math.max(right[j+1],max-prices[j]);
        }
        int result = 0;
        for(int i=0;i<n;i++){
            result = Math.max(result,left[i]+right[i]);
        }
        return result;
    }
}
