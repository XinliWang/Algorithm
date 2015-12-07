import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].

 */
public class Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        /**
         *  1.Using substring,traverse each 10-letter-long substring
         *  2.Using HashMap to store every substring,record the number of substring
         *  3.if the number is greater than 1, add to list
         */
        List<String> list = new ArrayList<>();
        int length = s.length();
        if(length<=10) return list;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<=length-10;i++){
            String string = s.substring(i,i+10);
            if(map.containsKey(string)){
             //   map.replace(string,Integer.valueOf(map.get(string)+1));
            }else{
                map.put(string,1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer val = (Integer)entry.getValue();
            if(val>1){
                String key = (String)entry.getKey();
                list.add(key);
            }
        }
        return list;

    }
}
