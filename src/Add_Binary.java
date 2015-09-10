/**
 * Given two binary strings, return their sum (also a binary string).
   For example,
    a = "11"
    b = "1"
    Return "100".
 */
public class Add_Binary {
    public String addBinary(String a, String b) {
        int sizeA = a.length();
        int sizeB = b.length();
        int i = sizeA-1,j = sizeB-1;
        int extra = 0;
        int numA = 0, numB = 0;
        String result = "";
        while(i>=0 && j>=0){
            numA = a.charAt(i)-'0';
            numB = b.charAt(j)-'0';
            if(numA+numB+extra==3){
                extra = 1;
                result = 1 + result;
            }else if(numA+numB+extra==2){
                extra = 1;
                result = 0 + result;
            }else if(numA+numB+extra==1){
                extra = 0;
                result = 1 + result;
            }else if(numA+numB+extra==0){
                extra = 0;
                result = 0 + result;
            }
            i--;
            j--;
        }
        if(i<0){
            for(;j>=0;j--){
                if(extra==0){
                    result = b.substring(0,j+1)+result;
                    return result;
                }else{
                    numB = b.charAt(j)-'0';
                    if(numB+extra==2){
                        extra = 1;
                        result = 0 + result;
                    }else{
                        extra =0;
                        result = 1 +result;
                    }
                }
            }
        }
        if(j<0){
            for(;i>=0;i--){
                if(extra==0){
                    result = a.substring(0,i+1)+result;
                    return result;
                }else{
                    numA = a.charAt(i)-'0';
                    if(numA+extra==2){
                        extra = 1;
                        result = 0 + result;
                    }else{
                        extra =0;
                        result = 1 +result;
                    }
                }
            }
        }

        if(extra==1) result = 1 + result;
        return result;
    }
}
