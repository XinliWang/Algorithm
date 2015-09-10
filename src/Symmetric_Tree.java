/**
 * My Submissions Question Solution
   Given a binary tree, check whether it is a mirror of itself
   (ie, symmetric around its center).
   For example, this binary tree is symmetric:

         1
        / \
       2   2
      / \ / \
     3  4 4  3
 But the following is not:
         1
        / \
       2   2
        \   \
        3    3

 */
public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        if(root.left==null && root.right==null)return true;
        if(root.left!=null && root.right==null)return false;
        if(root.left==null && root.right!=null)return false;
        return compareNode(root.left,root.right);
    }
    boolean compareNode(TreeNode first, TreeNode second){
        if(first==null && second==null)return true;
        if(first==null && second!=null)return false;
        if(first!=null && second==null)return false;
        if(first.val != second.val)return false;
        return compareNode(first.left,second.right) && compareNode(first.right,second.left);
    }
}
