import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.
 */
public class Ugly_Number_II {
    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int newNumber = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while(list.size()<n){
            //add increasingly,until the n-th element
            newNumber = Math.min(list.get(a)*2,Math.min(list.get(b)*3,list.get(c)*5));
            list.add(newNumber);
            if(list.get(a)*2 == newNumber) a++;
            if(list.get(b)*3 == newNumber) b++;
            if(list.get(c)*5 == newNumber) c++;
        }
        return list.get(list.size()-1);
    }
}
