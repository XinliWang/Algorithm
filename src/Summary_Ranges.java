import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates,
 * return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int size = nums.length;
        if(size==0) return list;
        int i=0;
        while(i<size){
            StringBuilder str = new StringBuilder();
            int index = nums[i];
            str.append(index);

            while(i<size-1 && nums[i]+1==nums[i+1]){
                i++;
            }
            if(index!=nums[i]){
                str.append("->");
                str.append(nums[i]);
            }
            list.add(str.toString());
            i++;
        }
        return list;
    }
}
