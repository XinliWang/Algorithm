import java.util.Arrays;
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

    public int singleNumber2(int[] nums){
        Arrays.sort(nums);
        int i=0;
        for(;i<nums.length-1 && nums[i]==nums[i+1];i++){
        }
        return nums[i];
    }

    //bit manipulation
    public int singleNumber3(int[] nums){
        int[] digit = new int[32];
        for(int i=0;i<nums.length;i++){
            int mask = 1;
            for(int j=31;j>=0;j--){
                if((mask & nums[i])!= 0){
                    digit[j]++;
                }
                mask<<=1;
            }
        }
        int result = 0;
        for(int i=0;i<32;i++){
            if(digit[i]%3==1){
                result +=1;
            }
            if(i==31)continue;
            result<<=1;
        }
        return result;
    }


}
