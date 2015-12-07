package career.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入参数有： ArrayList<Integer> list, int windowSize
 要求返回： ArrayList<Integer>
 譬如一个[1, 2, 3, 4, 5] , windowSize = 2,
 那么返回就是 [3, 5, 7, 9] （每两个数相加）
 */
public class WindowSum {
    /**
     * Solution1: two loops to do it
     */
    public static List<Integer> windowSum(ArrayList<Integer> list, int windowSize){
        int size = list.size();
        List<Integer> result = new ArrayList<>();
        if(size<windowSize)return result;
        for(int i=0;i<=size-windowSize;i++){
            int sum = 0;
            for(int j=0;j<windowSize;j++){
                sum += list.get(j+i);
            }
            result.add(sum);
        }
        return result;
    }

    /**
     * Solution2: O(n)
     * 1.At first we calculate the first windowSize sum
     * 2.each time we add new one and subtract old one
     *
     */
    public static int[] windowSum(int[] list, int windowSize){
        int size = list.length;
        int[] result = new int[size-windowSize+1];
        int current = 0;
        for(int i=0;i<windowSize;i++){
            current += list[i];
        }
        result[0] = current;
        for (int j=1;j<=size-windowSize;j++){
            current = current + list[j+windowSize-1]-list[j-1];
            result[j] = current;

        }
        return result;
    }


    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i=0;i<10;i++){
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        list2 = windowSum(list1,3);

        int[] l = {0,1,2,3,4};
        int[] ls = windowSum(l,3);

        for(int num:ls){
            System.out.println(num);
        }
    }
}
