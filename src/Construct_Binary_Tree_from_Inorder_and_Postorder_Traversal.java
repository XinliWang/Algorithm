/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */

/**
 *       1
 *     /   \
 *    2     3
 *     \   /
 *      4 5
 *  Inorder:   2,3,1,5,3
 *  Postorder: 4,2,5,3,1
 *
 *  1.First of all, we need get the root, it is the last element of the postorder
 *  2.We get the position of the root in Inorder in order to get the size of left and right tree.
 *  3.it is easy to see nodes of inorder, the left of root is left tree and nodes in the right is right tree
 *  4.we can get the left side and right side in postorder through inorder.
 *  5.The most important thing is getting the root of the leftTree and rightTree each time.
 *
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
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length){
            return null;
        }
        int size = inorder.length;
        return helper(inorder,postorder,0,size-1,0,size-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder,int startIn,int endIn,int startPost,int endPost){
        if(startIn>endIn || startPost>endPost){
            return null;
        }
        //the last element of postorder is root
        TreeNode root = new TreeNode(postorder[endPost]);
        //get this root's position in inorder in order to get the left side and right side of inorder
        int rootPosition=-1;
        for(int i=startIn;i<=endIn;i++){
            if(inorder[i]==root.val){
                rootPosition = i;
                break;
            }
        }
        //get the size of leftTree and rightTree in order to get the left side and right side of postorder
        if(rootPosition==-1)return null;
        int leftTreeSize = rootPosition - startIn;
        int rightTreeSize = endIn - rootPosition;

        //recursive function to get the right Tree and left Tree
        root.left = helper(inorder,postorder,startIn,rootPosition-1,startPost,startPost+leftTreeSize-1);
        root.right = helper(inorder, postorder, rootPosition+1, endIn, endPost-rightTreeSize, endPost-1);
        return root;
    }
}
