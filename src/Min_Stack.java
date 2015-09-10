import java.util.Stack;

/**
 * Design a stack that supports push, pop, top,
 * and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class Min_Stack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty()||minStack.peek()>=x){
            minStack.push(x);
        }
    }

    public void pop(){
        if(stack.isEmpty()){
            return;
        }
        int x = stack.peek();
        if(!minStack.isEmpty() && x == minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        if(minStack.isEmpty()){
            return 0;
        }
        return minStack.peek();
    }
}
