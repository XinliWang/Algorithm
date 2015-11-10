/**
 * Given a binary tree, determine if it is height-balanced.
   For this problem, a height-balanced binary tree is defined as a binary tree
   in which the depth of the two subtrees of every node never differ by more than 1.
Balanced binary tree definition:
 This test case is a tree like the following:

            1
        2       2
      3   3   3   3
     4 4 4 4 4 4
    5 5
 It's balanced. The depth of the left node of the node 1 is 4, and the depth of the right node of the node is 3.
 4 and 3 are not differed by more than 1 so it's balanced.

 1) Left subtree of T is balanced
 2) Right subtree of T is balanced
 3) The difference between heights of left subtree and right subtree is not more than 1.

 */
//求平衡二叉树问题
public class Balanced_Binary_Tree {
    /**
     * Solution1:
     * 1. use recursive solution
     * 2. each time we need compare the maximum depth of left side and right side for each node
     * 3. if the difference is more than 1, it is not balanced binary tree
     * 4. if the difference is not more than 1, we continue to compare the children node(left and right)
     * 5. Therefore, every time we need calculate the left deepest depth and right deepest depth and test it.
     * 6. It costs too much time.
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


    /**
     * Solution2:
     * 1.use recursive solution
     * 2.we can use post-order traverse the tree to solve it.
     * 3.At first, it will compare the left last parent node, it is bottom up method
     * 4.We will record left and right depth in every step, so we only need traverse every node once
     * 5.Therefore the runtime is faster
     */
    public boolean isBalanced2(TreeNode root){
        //only test it once, the final time
        return helper(root)!=-1;
    }
    private int helper(TreeNode node){
        //at first we need declare the final condition
        if(node==null)return 0;
        //use post-order solution
        int left = helper(node.left);
        int right = helper(node.right);
        //we only need get -1 once, then last all times we will return -1
        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        //get the one side depth if it's normal
        return Math.max(left,right)+1;
    }
}
