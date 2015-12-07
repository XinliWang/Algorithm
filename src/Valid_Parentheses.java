import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 The brackets must close in the correct order,
 "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Valid_Parentheses {
    //Solutio1:
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp=='('||temp=='['||temp=='{'){
                stack.push(temp);
            }else{
                if(stack.isEmpty())return false;
                switch (stack.pop()){
                    case '(': if(temp!=')')return false;
                              break;
                    case '[': if(temp!=']')return false;
                              break;
                    case '{': if(temp!='}')return false;
                              break;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return false;
    }
    //Solution2: use stack and hashmap
    public boolean isValid2(String s) {
        int size = s.length();
        if(size==0)return true;
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i=0;i<size;i++){
             char c = s.charAt(i);
             if(c=='('||c=='['||c=='{'){
                 stack.push(c);
             }
             if(c==')'||c=='}'||c==']'){
                 if(stack.isEmpty()||map.get(c)!=stack.pop())return false;
             }
        }
        if(!stack.isEmpty())return false;
        return true;
    }

}
