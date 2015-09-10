import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 The brackets must close in the correct order,
 "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Valid_Parentheses {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char temp = '\0';
        for(int i=0;i<s.length();i++){
            temp = s.charAt(i);
            if(temp=='('||temp=='['||temp=='{'){
                stack.push(temp);
            }else{
                if(stack.empty()){
                    return false;
                }else if(stack.peek()=='('){
                    if(temp==')')stack.pop();
                    else return false;
                }else if(stack.peek()=='['){
                    if(temp==']')stack.pop();
                    else return false;
                }else if(stack.peek()=='{'){
                    if(temp=='}')stack.pop();
                    else return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }

}
