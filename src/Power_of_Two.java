/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Power_of_Two {
    public boolean isPowerOfTwo(int n){
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


    public static void main(String[] args){
        Power_of_Two u = new Power_of_Two();
        boolean i = u.isPowerOfTwo(8);
        System.out.print(i);
//        boolean i = (double)3/2==1;

    }
}
