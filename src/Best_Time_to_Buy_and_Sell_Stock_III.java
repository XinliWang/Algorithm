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
public class Best_Time_to_Buy_and_Sell_Stock_III {
    /**
     * Solution1:divide and conquer
     * 1.from left to right, first transaction's max profit
     * 2.from right to left, second transaction's max profit
     * 3. add together, get the max
     */

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

    /**
     * Solution2: DP
     * 1. Assume we only have 0 money at first; 4 Variables to maintain some interested 'ceilings' so far:
     * 2. The maximum of if we've just buy 1st stock,
     *    if we've just sold 1nd stock,
     *    if we've just buy 2nd stock,
     *    if we've just sold 2nd stock.
     */
    public int maxProfit2(int[]prices){
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}
