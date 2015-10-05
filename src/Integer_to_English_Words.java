/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.

 For example,
 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 Hint:

 Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 */
public class Integer_to_English_Words {
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        String[] bigs = {"","Thousand","Million","Billion"};
        String[] smalls = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        int count=0;
        StringBuilder result = new StringBuilder();
        while(num!=0){
            int cur = num%1000;
            int h=cur/100, t=cur/10%10, o=cur%10;
            StringBuilder builder = new StringBuilder();
            if(h!=0){
                builder.append(ones[h]+" Hundred ");
            }
            if(t==1){
                builder.append(smalls[o]+" ");
            }else{
                if(t>1){
                    builder.append(tens[t]+" ");
                }
                if(o>0){
                    builder.append(ones[o]+" ");
                }
            }
            if(builder.length()!=0)builder.append(bigs[count]+" ");
            result.insert(0,builder);
            count++;
            num /= 1000;
        }
        return result.toString().trim();
    }
}
