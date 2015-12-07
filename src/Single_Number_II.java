import java.util.HashMap;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 */
public class Single_Number_II {
    public int singleNumber(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
              //  map.replace(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(int i:nums){
            if(map.get(i)!=3)return i;
        }
        return -1;
    }
}
