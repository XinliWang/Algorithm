/**
 * Given string A representative a positive integer which has N digits,
 * remove any k digits of the number, the remaining digits are arranged
 * according to the original order to become a new positive integer.
 * Make this new positive integers as small as possible.

 N <= 240 and k <= N,

 Example
 Given an integer A="178542", k=4

 return a string "12"

 Tags Expand
 Greedy LintCode Copyright
 */
public class Delete_Digits {
    /**
     *
     the ascending order is ok, we need to find out the first element which is not match.
     We need to execute k times to delete k elements.
     */
    public String DeleteDigits(String A,int k){
        int size = A.length();
        if(size==k){
            return "";
        }
        //check and execute
        for(int i=0;i<k;i++){
            for(int j = 0;j<A.length();j++){
                if(j == A.length()-1){
                    A = remove(A,j);
                    break;
                }
                //char to int
                int a = A.charAt(j)-'0';
                int b = A.charAt(j+1)-'0';
                if(a>b){
                    A = remove(A,j);
                    break;
                }
            }
        }

        //if the integer is 36012,k=2. then the result is 012, but the answer is 12.
        int z =0;
        while(z<A.length() && (A.charAt(z)-'0'==0)){
            z++;
        }
        return A.substring(z,A.length());

    }
    private String remove(String A, int pos){
        int sizeA = A.length();
        A = A.substring(0,pos)+A.substring(pos+1,sizeA);
        return A;
    }

}
