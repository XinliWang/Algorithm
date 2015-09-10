/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 */

/**
 * 本题思路：
 * 1.两数相乘长度绝对不会超过两数长度之和，例如99*99，长度不会超过10000即5.
 * 2.以234*57为例，个位计算：4*7，十位计算：3*7+4*5，百位计算：2*7+3*5，千位计算：2*5
 * 3.注意每次的进位
 */
public class Multiply_Strings {
    public String multiply(String num1, String num2) {
        //方便计算，用StringBuilder使string反转，个位在前
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int size1 = num1.length();
        int size2 = num2.length();
        //operation1
        int[] result = new int[size1+size2];
        //operation2
        for (int i=0;i<size1;i++){
            int x = num1.charAt(i)-'0';
            for(int j=0;j<size2;j++){
                int y = num2.charAt(j)-'0';
                result[i+j] += x*y;
            }
        }
        //operation3
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<result.length;i++){
            int digit = result[i]/10;
            int carry = result[i]%10;
            //每确定一位，往string的第一位插入，此操作只能用StringBuilder/StringBuffer
            sb.insert(0,digit);
            if (i<result.length-1){
                result[i+1] += carry;
            }
        }
        //去除最前面插入的0
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()>0? sb.toString():"0";
    }
}
