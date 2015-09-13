import java.util.Comparator;
import java.util.Arrays;

/**
 * Given a list of non negative integers,
 * arrange them such that they form the largest number.

 Example
 Given [1, 20, 23, 4, 8], the largest formed number is 8423201.

 Note
 The result may be very large, so you need to return a string instead of an integer.

 Tags Expand
 Sort
 */
public class Largest_Number {
    public String largestNumber(int[] nums){
        if(nums==null||nums.length==0){
            return "";
        }
        String[] array = new String[nums.length];

        //convert integer Array to String Array
        for(int i=0;i<nums.length;i++){
            array[i] = String.valueOf(nums[i]);
        }

        //sort to a new array that matches condition
        Arrays.sort(array,new NewComparator());


        //convert Array to String
        String str = "";
        for(String arr:array){
            str = arr + str;
        }
        //if the value of array are all 0, we just stay one.
        int i = 0;
        while(i < nums.length-1){
            if(str.charAt(i)!='0'){
                break;
            }
            i++;
        }
        return str.substring(i);
    }
}

//need to override a new compare function,such that
// if s1=3,s2 = 32,then s1+s2 =332,s2+s1 = 323,so s1+s2 is bigger.
class NewComparator implements Comparator<String>{
    @Override
    public int compare(String s1,String s2){
        return (s1+s2).compareTo(s2+s1);
    }
}