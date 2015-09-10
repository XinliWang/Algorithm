/**
 * Given a binary tree, determine if it is height-balanced.
   For this problem, a height-balanced binary tree is defined as a binary tree
   in which the depth of the two subtrees of every node never differ by more than 1.
 */
//求平衡二叉树问题
public class Balanced_Binary_Tree {
    /**
     * 1. use recursive solution
     * 2. each time we need compare the maximum depth of left side and right side
     * 3. if the difference is more than 1, it is not balanced binary tree
     * 4. if the difference is not more than 1, we continue to compare the children node
     *
     */
    public boolean isBalanced(TreeNode root){
        if(root==null)return true;
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    private int maxDepth(TreeNode node){
        if(node==null)return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
    }
}
