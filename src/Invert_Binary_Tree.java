import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.

       4
     /   \
    2     7
   / \   / \
  1   3 6   9

 to
       4
     /   \
    7     2
   / \   / \
  9   6 3   1
 */
//use BFS, we will have asymmetric situation :  1,2,3,4 -> 1,3,2,null,null,null,4


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




public class Invert_Binary_Tree {

    /**
     * Iterative solution:
     */
    public TreeNode invertTree(TreeNode root){
        if(root==null)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return root;
    }

    /**
     * Recursive solution:
     */
    public TreeNode invertTree2(TreeNode root){
        //when the loop get to leaf
        if(root==null) return null;
        //record left node of every level
        TreeNode temp = root.left;
        //use recursive way to put right node to the left place to calculate
        root.left = invertTree2(root.right);
        //then put left node to the right place ot calculate
        root.right = invertTree2(temp);
        /**
         * 1. from last level to switch and return to previous level
         * 2. at last return to first level and get the root node
         */

        return root;
    }
}
