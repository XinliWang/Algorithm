import java.util.HashSet;

/**
 * Given a (decimal - e.g. 3.72) number that is passed in as a string,
 * return the binary representation that is passed in as a string.
 * If the number can not be represented accurately in binary, return ERROR

 Example
 For n=3.72, return ERROR

 For n=3.5, return 11.1

 Tags Expand
 String Cracking The Coding Interview Bit Manipulation Binary Representation
 */
public class Binary_Representation {
    public String binaryRepresentation(String n){
        //divide and conquer, according to '.'
        if(n.indexOf('.')==-1){
            return parseInteger(n);
        }

        /**
         * 用双斜杠的原因：
         “.”在正则表达式中匹配任意字符，为了匹配“.”含义本身，需要使用 \.
         而 \ 在java中也是用于转义的，必须使用 \\ 进行转义
         所以必须使用 \\. 来表示 “.” 本身的含义
         */
        String[] params  = n.split("\\.");
        String sideB = parseFloat(params[1]);
        if(sideB.equals("ERROR")){
            return "ERROR";
        }
        if(sideB.equals("0")||sideB.equals("")){
            return parseInteger(params[0]);
        }
        return parseInteger(params[0])+"."+sideB;
    }

    //handle the integer part
    private String parseInteger(String str){
        if(str.equals("")||str.equals("0")){
            return "0";
        }
        int n = Integer.parseInt(str);
        String binary ="";

        while(n!=0) {
            binary =Integer.toString(n%2) + binary;
            n = n / 2;
        }
        return binary;
    }

    //handle the decimal part
    private String parseFloat(String str){

        Double d = Double.parseDouble("0."+ str);
        HashSet<Double> set = new HashSet<>();
        String binary = "";

        //every step,we use the number multiply 2,if greater than 1, get 1, subtract 1. else get 0. At last combine it.
        while(d>0){
            if(binary.length()>32||set.contains(d)){
                return "ERROR";
            }
            set.add(d);
            d =d*2;
            if(d>=1){
                binary = binary+"1";
                d=d-1;
            }else{
                binary = binary+"0";
            }
        }
        return binary;

    }
}
