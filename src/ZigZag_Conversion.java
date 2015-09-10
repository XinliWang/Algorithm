/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZag_Conversion {
    /**
     *  1.we can have a String array,its size is numRows.
     *  2.each time we traverse every char of String, then add char to String array one by one from head to tail
     *  3.Then add char to String array one by one from tail to head
     *  4.combine all elements of String Array
     */
    public String convert(String s, int numRows) {
        int size = s.length();
        String[] strings = new String[numRows];
        for (int i=0;i<numRows;i++){
            strings[i] = "";
        }
        boolean index = true;
        int row = 0;
        for (int i=0;i<size;i++){
            strings[row] += s.charAt(i);
            if(numRows>1){
                if(row==0){
                    row++;
                    index = true;
                }else if(row==numRows-1){
                    row--;
                    index = false;
                }else if(index){
                    row++;
                }else{
                    row--;
                }
            }
        }
        String result = "";
        for(int i=0;i<numRows;i++){
            result += strings[i];
        }
        return result;
    }
}
