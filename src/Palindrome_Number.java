/**
 * Determine whether an integer is a palindrome. Do this without extra space.
   回文数字：121    2112  ，  小于0的数都不是回文数
 */
public class Palindrome_Number {
    public boolean isPalindrome(int x){
        if(x<0) return false;
        int temp =x;
        int size = 0;
        int left = 0;
        int right = 0;
        while(temp!=0){
            temp/=10;
            ++size;
        }
        int i=0;
        int j = size-1;
        for(;i<j;i++,j--){
            left = (int)(x/Math.pow(10,j)%10);
            right = (int)(x/Math.pow(10,i)%10);
            if(left!=right)return false;
        }
        return true;
    }
}
