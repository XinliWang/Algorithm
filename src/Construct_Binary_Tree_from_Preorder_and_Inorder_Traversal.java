/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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


/**
 *  1.the same as the Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal
 *  2.the most important thing is getting the root from the preorder
 *  3.it is easy to know the root is the first element of preorder
 *  4.each time we get the size of left and right tree from inorder in order to get the first position in preorder
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length)return null;
        int size = inorder.length;
        return helper(preorder,inorder,0,size-1,0,size-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder,int startPre,int endPre,int startIn,int endIn){
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPre]);
        int rootPosition = -1;
        for(int i=startIn;i<=endIn;i++){
            if(root.val == inorder[i]){
                rootPosition = i;
                break;
            }
        }
        //get the left and right size
        int leftTreeSize = rootPosition - startIn;
        int rightTreeSize = endIn - rootPosition;

        root.left = helper(preorder, inorder, startPre+1, startPre + leftTreeSize, startIn, rootPosition-1);
        root.right = helper(preorder, inorder,endPre - rightTreeSize +1, endPre, rootPosition+1,endIn);
        return root;
    }
}
