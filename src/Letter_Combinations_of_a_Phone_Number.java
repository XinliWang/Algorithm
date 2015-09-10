import java.util.ArrayList;
import java.util.List;

/**
 * My Submissions Question Solution
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 1: ""       2: "abc"     3: "def"
 4: "ghi"    5: "jkl"     6: "mno"
 7: "pqrs"   8: "tuv"     9: "wxyz"
             0: " "
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits){
        //数字对应的即为字母
        String[] directory = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> list = new ArrayList<>();
        int size = 0;

        //add first element
        String s = directory[digits.charAt(0)-'0'];
        int length = s.length();
        if(length==0){
            list.add("");
        }else if(length==1){
            list.add(" ");
        }else{
            for(int i=0;i<length;i++){
                list.add(String.valueOf(s.charAt(i)));
            }
        }

        for(int i=1;i<digits.length();i++){
            int index = digits.charAt(i)-'0';
            String str = directory[index];
            size = str.length();
            if(size == 0){
                continue;
            }else if(size==1){
                list.add(" ");
            }else{
                ArrayList<String> tempList = new ArrayList<>();
                for(int j=0;j<size;j++){
                    for(int m=0;m<list.size();m++){
                        tempList.add(list.get(m)+str.charAt(j));
                    }
                }
                list.clear();
                list.addAll(tempList);
            }
        }
        return list;
    }

    public static void main(String[] args){
        Letter_Combinations_of_a_Phone_Number le = new Letter_Combinations_of_a_Phone_Number();
        le.letterCombinations("223");
    }


}
