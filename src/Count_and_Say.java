/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */
public class Count_and_Say {
    public String countAndSay(int n){
        if(n==1)return "1";
        String result ="1";

        while(n!=1){
            int size = result.length();
            char prev = '\0';
            char cur = '\0';
            String temp = "";
            int count=1;
            for(int i=0;i<size;i++){
                prev = result.charAt(i);
                if(n+1!=size){
                    cur = result.charAt(i+1);
                    if(prev == cur){
                        count++;
                    }else{
                        temp += count + String.valueOf(prev);
                        count = 1;
                    }
                }else{
                    temp += count + String.valueOf(prev);
                }
            }
            result = temp;
            n--;
        }
        return result;
    }
}
