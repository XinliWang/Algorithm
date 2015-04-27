/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 are not zero-based.

 Example
 numbers=[2, 7, 11, 15], target=9

 return [1, 2]

 Note
 You may assume that each input would have exactly one solution

 Challenge
 1. O(1) Space, O(nlogn) Time

 2. O(n) Space, O(n) Time

 Tags Expand
 Two Pointers Sort Array
 */
public class Sum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] A = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (target == (numbers[i] + numbers[j])) {
                    A[0] = i + 1;
                    A[1] = j + 1;
                    return A;
                }
            }
        }
        return null;
    }
}