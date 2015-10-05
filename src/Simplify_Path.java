/**
 *Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 click to show corner cases.

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".
 */


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * 1. 把String按“/”分割成String数组
 * 2. 如果是""(代表有//出现),".",".."则直接跳过
 * 3. 把所有字母存入stack，如果有“..”则删除之前存入的字母，没有则存入
 * 4. 最后从stack的最下面依次取出字母和“/“结合
 */
public class Simplify_Path {
    public String simplifyPath(String path) {
        HashSet<String> set = new HashSet<>();
        set.add("");
        set.add(".");
        set.add("..");
        Deque<String> stack = new ArrayDeque<>();
        for(String s:path.split("/")){
            if(s.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            if(set.contains(s))continue;
            stack.push(s);
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append("/"+stack.pollLast());
        }
        if(builder.length()==0){
            return "/";
        }else{
            return builder.toString();
        }
    }
}
