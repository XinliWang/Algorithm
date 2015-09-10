/**
 * Implement pow(x, n).
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
}
