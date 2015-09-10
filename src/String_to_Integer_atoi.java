/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases.
 If you want a challenge, please do not see below and
 ask yourself what are the possible input cases.

 Requirements for atoi:
 The function first discards as many whitespace characters as necessary until
 the first non-whitespace character is found. Then, starting from this character,
 takes an optional initial plus or minus sign followed by as many numerical digits
 as possible, and interprets them as a numerical value.
 The string can contain additional characters after those that form the integral number,
 which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters,
 no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.
 If the correct value is out of the range of representable values,
 INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 规则：该字符串可能有空格，可能有字母，输出字母出现之前的数字，全是字母返回0，如果有两个符号返回0，
    一个符号说明有正负。超出整数表示范围，返回0
*/

 public class String_to_Integer_atoi {
    public int myAtoi(String str){
        String s = str.trim();
        int size = s.length();
        if(size==0)return 0;
        char sign='\0';
        StringBuilder build = new StringBuilder();
        int result =0;
        if(s.charAt(0)=='+'){
            sign = '+';
        }else if(s.charAt(0)=='-'){
            sign = '-';
        }else if(s.charAt(0)-'0'<10&&s.charAt(0)-'0'>=0){
            build.append(s.charAt(0));
        }else{
            return 0;
        }
        for(int i=1;i<size;i++){
            if(s.charAt(i)=='+'||s.charAt(i)=='+'){
                return 0;
            }else if(s.charAt(i)-'0'<10&&s.charAt(i)-'0'>=0){
                build.append(s.charAt(i));
            }else {
                break;
            }
        }
        int length = build.length();
        if(length==0)return 0;
        else{
            if(sign=='-'){
                for(int j=0;j<length;j++){
                    result -= Math.pow(10,length-j-1);
                    if(result<=Integer.MIN_VALUE)return Integer.MIN_VALUE;
                }
            }else{
                for(int j=0;j<length;j++){
                    result += Math.pow(10,length-j-1);
                    if(result>=Integer.MAX_VALUE)return Integer.MAX_VALUE;
                }
            }
        }
        return result;
    }
}
