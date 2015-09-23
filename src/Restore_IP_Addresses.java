import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 Hide Tags: Backtracking String

 */
public class Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s==null || s.length()==0 || s.length()>12){
            return list;
        }
        //In order to transfer string to ip address
        StringBuilder builder = new StringBuilder();
        helper(list,builder,s,0,0);
        return list;
    }
    public void helper(List<String> list,StringBuilder builder,String s,int start,int count){
        //if we just use all of character to form an IP Address,then save it.
        if(count==3 && start==s.length()){
            list.add(s);
        }

        for(int i=start+1;i<=s.length();i++){
            String temp = s.substring(start,i);
            if(temp.length()>3 || temp.length()>1&&temp.charAt(0)=='0'||Integer.parseInt(temp)>255){
                return;
            }
            StringBuilder newBuilder = new StringBuilder(builder);
            //if newBuilder is null,we only need append substring,otherwise we need append "."
            if(newBuilder.length()!=0){
                newBuilder.append(".");
            }
            newBuilder.append(temp);
            /**
             * 1.Using recursive function to go on the next substring
             * 2.if the length of temp is the same with newBuilder, which means it is the first substring without "."
             *  the last three substring all with ".", we should count the number of "."
             */

            helper(list,builder,s,i,temp.length()==newBuilder.length()?count:count+1);
        }
    }


}
