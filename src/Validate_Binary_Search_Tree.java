/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
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
public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        //in case of the value of node is the Min or max value
        return isValidValue(root,(long)Integer.MIN_VALUE-1,(long)Integer.MAX_VALUE+1);
    }

    public boolean isValidValue(TreeNode node,long min,long max){
        //reach the last one successfully
        if(node==null)return true;
        if(node.val<=min || node.val>=max)return false;
        return isValidValue(node.left,min,node.val) && isValidValue(node.right,node.val,max);
    }
}
