/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */

//每一位都需要判断相邻和以该位为中点两边对称的情况
public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s){
        int size = s.length();
        if(size==0||size==1)return s;
        int left = 0, right = 0;
        //记录起始位置
        int index = 0;
        //记录长度
        int maxSize = 0;
        for(int i=0;i<size-1;i++){
            left = i;
            right = i+1;
            while(left>=0 && right!=size){
                if(s.charAt(left)==s.charAt(right)){
                    if(right-left+1>maxSize){
                        index  = left;
                        maxSize = right - left +1;
                    }
                    --left;
                    ++right;
                }else{
                    break;
                }
            }
            left = i-1;
            right = i+1;
            while(left>=0 && right!=size){
                if(s.charAt(left)==s.charAt(right)){
                    if(right-left+1>maxSize){
                        index  = left;
                        maxSize = right - left +1;
                    }
                    --left;
                    ++right;
                }else{
                    break;
                }
            }

        }
        return s.substring(index,index+maxSize);
    }

    public String longestPalindrome2(String s){
        int size = s.length();
        if(size==0 || size==1) return s;
        int maxCount = 1;
        int c=0;
        String string = "";
        for(int i =0;i<size;i++){
            //odd substring
            for(int j=1;i-j>=0 && i+j<size;j++){
                if(s.charAt(i-j)!=s.charAt(i+j)){
                    break;
                }
                c = 2*j+1;
            }
            if(c>maxCount){
                maxCount = c;
                string = s.substring(i-(maxCount-1)/2,1+i+(maxCount-1)/2);

            }

            //even substring
            for(int j=0;i-j>=0 && i+j+1<size;j++){
                if(s.charAt(i-j) != s.charAt(i+j+1)){
                    break;
                }
                c = 2*j+2;
            }
            if(c>maxCount){
                maxCount = c;
                string = s.substring(i-(maxCount-2)/2,i+1+(maxCount-2)/2);

            }


        }
        return string;
    }

    public static void main(String[] args){
        Longest_Palindromic_Substring l = new Longest_Palindromic_Substring();
        l.longestPalindrome2("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
    }

}
