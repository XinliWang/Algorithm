/**
 * Calculate the an % b where a, b and n are all 32bit integers.

 Example
 For 2^31 % 3 = 2

 For 100^1000 % 1000 = 0

 Challenge
 O(logn)

 Tags Expand
 Divide and Conquer
 */
public class Fast_Power {
    public int fastPower(int a,int b,int n){
        //we can use recursion
        return (int)helper(a,b,n);
    }
    private long helper(int a,int b,int n){
        if(a==0)return 0;
        if(n==0)return 1%b;
        if(n==1)return a%b;
        long ret;
        //we can use the module formula, (a*b)%p = (a%p * b%p)%p
        ret = helper(a, b, n/2);
        ret *= ret;
        //prevent leak
        ret = ret%b;

        //the last step: n = 1
        if(n%2==1){
            ret = ret*(a%b);
        }
        ret = ret%b;

        return ret;
    }
}
