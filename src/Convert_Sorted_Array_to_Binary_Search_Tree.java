/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
    //recursive
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        return helper(nums,0,nums.length-1);
    }
    //each time we make the middle of the array to be the root
    private TreeNode helper(int[] nums, int begin, int end){
        if(begin>end) return null;
        int middle = begin + (end - begin)/2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = helper(nums, begin , middle-1);
        node.right = helper(nums, middle+1, end);
        return node;
    }
}
