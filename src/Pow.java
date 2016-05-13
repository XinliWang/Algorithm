/**
 * Implement pow(x, n).  即x^n
 */
//使用recursive
public class Pow {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        double result = myPow(x,n/2);
        if(n%2==0)return result*result;
        else return result*result*x;
    }

    //binary search , O(lgn)
    public double myPow2(double x,int n){
        if(n==0)return 1;
        if(n==1)return x;
        int sign = n>0? n : -n;
        double result = sign%2==0? myPow2(x*x,(int)n/2) : myPow2(x*x,(int)n/2)*x;
        return n>0? result : 1/result;
    }
}
