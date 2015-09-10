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
}
