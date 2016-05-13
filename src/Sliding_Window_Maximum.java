import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7      3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?
 */
public class Sliding_Window_Maximum {
    //Solution: O(n*k), use Array, when [5,4,3,2,1] =>The worst situation is O(n*k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length<2)return nums;
        int left = 0, right = k-1;
        int max = Integer.MIN_VALUE, maxIndex = -1;
        int size = nums.length;
        int[] result = new int[size-k+1];
        while(right < size) {
            /**
             * if 每次移动去除的那一位数字是最大的,则需要重新再数组中计算，找出最大值
             */
            if(maxIndex<left) {
                max = nums[left];
                maxIndex = left;
                for(int i = left+1; i<=right; i++) {
                    if(nums[left]>=max){
                        max = nums[left];
                        maxIndex = left;
                    }
                }
            }else{
                if(nums[right] >= max){
                    max = nums[right];
                    maxIndex = right;
                }
            }
            result[left] = max;
            left++;
            right++;
        }
        return result;
    }

    //Solution2: O(n) , use Deque to store index
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length<2)return nums;
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        int size = nums.length;
        int[] result = new int[size-k+1];
        //排列前k个值的索引,保留在后的较大值
        for(;index<k;index++){
            //如果是3，2，1则需要全部存储其index为2，1，0，如果是1，3，2，则值存储index 2,1
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[index]) {
                deque.removeLast();
            }
            deque.addLast(index);
        }

        for(;index<size;index++) {
            result[index-k] = nums[deque.getFirst()];

            //若每次移动除去的那位最大
            if(deque.getFirst()<index-k){
                deque.removeFirst();
            }
            //若即将加进来的数最大，则删去后面较小的数
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[index]) {
                deque.removeLast();
            }
            deque.addLast(index);
        }
        result[index-k] = nums[deque.getFirst()];
        return result;
    }

}
