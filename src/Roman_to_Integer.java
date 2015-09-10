import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 I(1)、V(5)、X(10)、L(50)、C(100)、D(500)、M(1000)
 左减数字不可跨越一个位数，
 数字小的在前用减，数字大的在前用加。
 */




public class Roman_to_Integer {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        for(int i=0;i<s.length();i++){
            if (i!=s.length()-1&& map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                sum -= map.get(s.charAt(i));
            }else{
                sum +=map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
