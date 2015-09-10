/**
 * Given a column title as appear in an Excel sheet,
 * return its corresponding column number.
 行号
 For example:
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
//26进制转化为10进制
public class Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int size = s.length();
        int result = 0;
        for(int i=0;i<size;i++){
           result = result + s.charAt(i)-'A'+1;
        }
        return result;
    }
}
