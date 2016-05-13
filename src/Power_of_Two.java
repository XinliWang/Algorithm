/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Power_of_Two {
    //Solution1
    public boolean isPowerOfTwo1(int n){
        if(n<=0) return false;
        while(n!=0){
            if(n<=2){
                return true;
            }
            if(n%2!=0){
                return false;
            }else {
                n /=2;
            }
        }
        return false;
    }

    //Solution2:
    public boolean isPowerOfTwo2(int n){
        int count = 0;
        while(n>0){
            count += (n & 1);
            n >>= 1;
        }
        return count == 1;

    }

    //Solution3:if n is power of Two, then n &(n-1) == 0
    public boolean isPowerOfTwo3(int n){
        return (n>0) && ((n & (n-1))==0);
    }

    
    public static void main(String[] args){
        Power_of_Two u = new Power_of_Two();
        boolean i = u.isPowerOfTwo1(8);
        System.out.print(i);
//        boolean i = (double)3/2==1;

    }
}
