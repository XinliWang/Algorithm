import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Example
 For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

 (-1, 0, 1)

 (-1, -1, 2)

 Note
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

 The solution set must not contain duplicate triplets.

 Tags Expand
 Two Pointers Sort Array
 */
public class Sum3 {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(numbers==null || numbers.length<3) return result;

        Arrays.sort(numbers);
        for(int i=0;i<numbers.length;i++){
            //保证数组递增,防止数组值都相等而出现list重复数组的情况(或者使用HashSet存储，再用list.addAll(set))
            if(i==0||numbers[i]>numbers[i-1]){
                int start = i+1;
                int end = numbers.length-1;
                while(start<end){
                    if((numbers[start]+numbers[end])== -numbers[i]){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[start]);
                        list.add(numbers[end]);
                        result.add(list);
                        ++start;
                        --end;
                        while(start<end && numbers[start] == numbers[start-1]){
                            ++start;
                        }
                        while(start<end && numbers[end] == numbers[end+1]){
                            --end;
                        }
                    }
                    else if((numbers[start]+numbers[end]) < -numbers[i]){
                        ++start;
                    }else if((numbers[start]+numbers[end]) > -numbers[i]){
                        --end;
                    }
                }

            }
        }
        return result;


    }
}
