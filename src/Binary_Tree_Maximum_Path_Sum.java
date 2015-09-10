/**
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 Example
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.

 Tags Expand
 Divide and Conquer Dynamic Programming Recursion Depth First Search.
 */
public class Binary_Tree_Maximum_Path_Sum {
    /**
     * Definition of TreeNode:
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left, right;
     *     public TreeNode(int val) {
     *         this.val = val;
     *         this.left = this.right = null;
     *     }
     * }
     */
    public int maxPathSum(TreeNode root){
        int[] max = {Integer.MIN_VALUE};
        rec(root,max);
        return max[0];
    }
    private int rec(TreeNode root , int[] max){
        if(root==null)return 0;
        int leftPathMax = rec(root.left,max);
        int rightPathMax = rec(root.right,max);
        int maxSubPath = leftPathMax+ root.val + rightPathMax;
        int maxRootToParent = Math.max(root.val,root.val+Math.max(leftPathMax,rightPathMax));
        max[0] = Math.max(max[0],Math.max(maxSubPath,maxRootToParent));
        return maxRootToParent;
    }

}

