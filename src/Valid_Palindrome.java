/**
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        //使用正则表达式（regular	expression）,把一切不是字母数字的部分消除，然后反转比较
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
