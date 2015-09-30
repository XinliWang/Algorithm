import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators,
 * return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.

 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]

 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]
 */
public class Different_Ways_to_Add_Parentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        int size = input.length();
        //recursive
        for(int i=0;i<size;i++){
            char c = input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                String a = input.substring(0,i);
                String b = input.substring(i+1,size);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for(int x : al){
                    for(int y : bl){
                        if(c=='+'){
                            list.add(x+y);
                        }else if(c=='-'){
                            list.add(x-y);
                        }else if(c=='*'){
                            list.add(x*y);
                        }
                    }
                }
            }
        }
        if(list.size()==0){
            list.add(Integer.valueOf(input));
        }
        return list;
    }
}
