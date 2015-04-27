/**
 * A message containing letters from A-Z is being
 * encoded to numbers using the following mapping:


 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits,
 determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded
 as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2
 */
public class Decode_Ways {
    public int numDecodings(String s){
        if(s.length() == 0)return 0;
        int[] nums = new int[s.length()];
        if(s.charAt(s.length()-1)!='0'){
            nums[s.length()-1] =1;
        }
        if(s.length()>=2){
            int value = Integer.parseInt(s.substring(s.length()-2,s.length()));
            if(value>=10 && value<=26){
                nums[s.length() - 2] = nums[s.length() -1]+1;
            }else if(s.charAt(s.length()-2)!='0'){
                nums[s.length() - 2] = nums[s.length() -1];
            }
            for(int i = s.length()-3;i>=0;i--){
                if(s.charAt(i)!='0'){
                    nums[i] = nums[i+1];
                }
                    value = (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
                    if(value >= 10 && value <= 26){
                        nums[i] = nums[i]+nums[i+2];
                    }
                }
            }

        return nums[0];
    }
}
