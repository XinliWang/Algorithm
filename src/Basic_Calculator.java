import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ),
 the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:
 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 Note: Do not use the eval built-in library function.
 */
public class Basic_Calculator {
    /**
     * Solution:
     * 1.使用sign标记每个数的符号位
     * 2.因为只有加减操作，所以可以直接去除括号，然后计算并根据sign来进行计算
     */
    public int calculate(String s) {
        //save the pre-sign
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result=0,val=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(sign);
            }else if(s.charAt(i)==')'){
                stack.pop();
            }else if(s.charAt(i)=='-'||s.charAt(i)=='+'){
                //先进行 +/-之前 那个值的计算
                result += val * sign;
                val = 0;
                //计算下次要计算时候用的sign
                if(stack.isEmpty()){
                    sign = s.charAt(i)=='-'? -1 : 1;
                }else{
                    sign = s.charAt(i)=='-'? stack.peek()*(-1) : stack.peek();
                }
            }else if(s.charAt(i)!=' '){
                val = val*10 + (s.charAt(i)-'0');
            }
        }
        result += val * sign;
        return result;
    }
    public static void main(String[] args){
        Basic_Calculator ds = new Basic_Calculator();
        System.out.print(ds.calculate("0"));
    }
}