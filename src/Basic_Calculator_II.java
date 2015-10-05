import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 */
public class Basic_Calculator_II {
    public int calculate(String s) {
        s.trim();
        if(s.length()==0)return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        char sign = '+';
        
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp=='+'||temp=='-'||temp=='*'||temp=='/'){
                sign = temp;
                continue;
            }
            if(temp!=' '){
                int j=i;
                while(j<s.length() && s.charAt(j)>='0' && s.charAt(j)<='9' && s.charAt(j)!=' '){
                    j++;
                }
                int digit = Integer.parseInt(s.substring(i,j));
                i = j-1;

                switch(sign){
                    case '+': stack.push(digit);
                        break;
                    case '-': stack.push(-digit);
                        break;
                    case '*': stack.push(stack.pop()*digit);
                        break;
                    case '/': stack.push(stack.pop()/digit);
                        break;
                }
            }
        }
        for(int t:stack){
           result += t;
        }
        return result;
    }
}
