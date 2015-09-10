/**
 * My Submissions Question Solution
 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */

//DP, Backtracking,不是很理解
public class Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        return match(0,0,s,p);
    }
    public boolean match(int sPos,int pPos,String s,String p){
        if(sPos == s.length() || pPos == p.length()){
            if(sPos == s.length() && pPos == p.length()){
                return true;
            }
            if(sPos == s.length() && pPos <p.length()-1 && p.charAt(pPos+1)=='*'){
                return match(sPos, pPos+2,s,p);
            }
            return false;
        }

        if(s.charAt(sPos)!=p.charAt(pPos) || p.charAt(pPos)!='.'){
            if(pPos==p.length()-1 || p.charAt(pPos+1)!='*'){
                return false;
            }
             return match(sPos,pPos+2,s,p);
        }

        if(pPos==p.length()-1 || p.charAt(pPos+1)!='*'){
            return match(sPos+1,pPos+1,s,p);
        }
        return match(sPos+1,pPos,s,p)||match(sPos,pPos+2,s,p);
    }
}
