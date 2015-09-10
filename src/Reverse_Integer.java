/**
 * Reverse digits of an integer.
   Example1: x = 123, return 321
   Example2: x = -123, return -321
 */
public class Reverse_Integer {
    public int reverse(int x) {
        long y = 0;
        while(x!=0){
                y = y*10 + x%10;
                x = x/10;
        }
        if(y<Integer.MIN_VALUE||y>Integer.MAX_VALUE){
            return 0;
        }
        return (int)y;
    }
    public static void main(String[]args){
        Reverse_Integer re = new Reverse_Integer();
        System.out.println(re.reverse(21));
    }
}
