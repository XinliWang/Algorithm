import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangxinli on 6/15/15.
 */
public class Basic_Calculator {
    public int calculate(String s) {
        Queue<Character> queueChar = new LinkedList<>();
        Queue<Integer> queueInt = new LinkedList<>();
        String temp = s.replaceAll(" ", "");
        for (int i = 0; i < temp.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                queueChar.add(s.charAt(i));
            } else {
                queueInt.add(s.charAt(i) - '0');
            }
        }
        int sum = queueInt.poll();
        char oper;
        while (queueChar != null && queueInt != null) {
            oper = queueChar.poll();
            if (oper == '+') {
                sum += queueInt.poll();
            } else if (oper == '-') {
                sum -= queueInt.poll();
            }
        }
        return sum;

    }
    public static void main(String[] args){
        Basic_Calculator ds = new Basic_Calculator();
        System.out.print(ds.calculate("0"));
    }
}